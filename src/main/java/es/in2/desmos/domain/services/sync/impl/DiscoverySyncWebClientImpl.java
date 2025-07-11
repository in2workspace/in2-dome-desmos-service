package es.in2.desmos.domain.services.sync.impl;

import es.in2.desmos.domain.exceptions.DiscoverySyncException;
import es.in2.desmos.domain.models.MVEntity4DataNegotiation;
import es.in2.desmos.domain.services.sync.DiscoverySyncWebClient;
import es.in2.desmos.domain.utils.EndpointsConstants;
import es.in2.desmos.infrastructure.security.M2MAccessTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscoverySyncWebClientImpl implements DiscoverySyncWebClient {
    private final WebClient webClient;
    private final M2MAccessTokenProvider m2MAccessTokenProvider;

    @Override
    public Flux<MVEntity4DataNegotiation> makeRequest(
            String processId,
            Mono<String> externalAccessNodeMono,
            String externalDomain,
            Flux<MVEntity4DataNegotiation> externalMVEntities4DataNegotiation) {

        log.info("ProcessID: {} - Making a Discovery Sync Web Client request for domain: {}", processId, externalDomain);

        return externalAccessNodeMono
                .zipWith(m2MAccessTokenProvider.getM2MAccessToken())
                .flatMapMany(tuple -> {
                    Flux<MVEntity4DataNegotiation> payloadToSend =
                            externalMVEntities4DataNegotiation
                                    .doOnNext(entity ->
                                            log.debug("ProcessID: {} - Payload for {}: {}", processId, externalDomain,entity));

                            return webClient
                                    .post()
                                    .uri(UriComponentsBuilder.fromHttpUrl(tuple.getT1())
                                            .path(EndpointsConstants.P2P_DISCOVERY_SYNC)
                                            .build()
                                            .toUriString())
                                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + tuple.getT2())
                                    .header("X-Issuer", externalDomain)
                                    .contentType(MediaType.valueOf("application/x-ndjson"))
                                    .accept(MediaType.valueOf("application/x-ndjson"))
                                    .body(payloadToSend, MVEntity4DataNegotiation.class)
                                    .exchangeToFlux(response -> {
                                        HttpStatusCode status = response.statusCode();

                                        if (status.is2xxSuccessful()) {
                                            log.info("ProcessID: {} - Discovery Sync successful, HTTP {}", processId, status);
                                            return response.bodyToFlux(MVEntity4DataNegotiation.class)
                                                    .doOnNext(entity -> log.debug("ProcessID: {} - Received entity: {}", processId, entity));
                                        } else {
                                            return response.bodyToMono(String.class)
                                                    .flatMapMany(errorBody -> {
                                                        log.error("ProcessID: {} - Error HTTP {}: {}", processId, status, errorBody);

                                                        if (status.is4xxClientError()) {
                                                            return Flux.error(new DiscoverySyncException(
                                                                    String.format("Error 4xx occurred while discovery sync. ProcessId: %s | X-Issuer: %s | Body: %s",
                                                                            processId, externalDomain, errorBody)));
                                                        } else if (status.is5xxServerError()) {
                                                            return Flux.error(new DiscoverySyncException(
                                                                    "Error 5xx occurred while discovery sync. Body: " + errorBody));
                                                        } else {
                                                            return Flux.error(new DiscoverySyncException(
                                                                    String.format("Unexpected HTTP error during discovery sync. Status: %s | Body: %s",
                                                                            status, errorBody)));
                                                        }
                                                    });
                                        }
                                    })
                                    .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(1))
                                            .filter(throwable -> !(throwable instanceof DiscoverySyncException)));
                        }
                );
    }
}
