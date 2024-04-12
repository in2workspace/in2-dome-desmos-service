package es.in2.desmos.domain.services.sync.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewEntitiesCreatorServiceImpl /*implements NewEntitiesCreatorService*/ {
    /*private final EntitySyncWebClient entitySyncWebClient;

    @Override
    public Mono<Void> addNewEntities(Mono<String> issuer, Mono<List<String>> externalEntityIds, @NotNull Mono<List<String>> internalEntityIds) {

        Mono<List<String>> entityIdsToAdd = getEntitiesToAdd(externalEntityIds, internalEntityIds);
        Mono<EntitySyncResponse> entitiesToAdd = requestNewEntities(entityIdsToAdd, issuer);

        return publishNewEntities(entitiesToAdd);
    }

    private Mono<List<String>> getEntitiesToAdd(Mono<List<String>> externalEntityIds, Mono<List<String>> internalEntityIds) {
        return internalEntityIds.flatMap(
                internalList -> externalEntityIds.flatMap(
                        externalList ->
                                externalEntityIds.flatMapIterable(list -> list)
                                        .filter(externalId -> !internalList.contains(externalId))
                                        .distinct()
                                        .collectList()
                )
        );
    }

    private Mono<EntitySyncResponse> requestNewEntities(Mono<List<String>> entityIdsToAdd, Mono<String> issuer) {
        Mono<List<Entity>> idRecordsToRequest = entityIdsToAdd.map(DiscoverySyncRequest::createExternalEntityIdsListFromString);

        Mono<EntitySyncRequest> entitySyncRequest = idRecordsToRequest.map(EntitySyncRequest::new);

        return entitySyncWebClient.makeRequest(issuer, entitySyncRequest);
    }

    private Mono<Void> publishNewEntities(Mono<EntitySyncResponse> newEntities) {
        // TODO
        log.info("New entities: {}", newEntities);
        return Mono.empty();
    }*/
}