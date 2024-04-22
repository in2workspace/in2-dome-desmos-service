package es.in2.desmos.domain.services.broker.impl;

import es.in2.desmos.domain.models.MVBrokerEntity4DataNegotiation;
import es.in2.desmos.domain.services.broker.BrokerEntityGetterService;
import es.in2.desmos.domain.services.broker.adapter.BrokerAdapterService;
import es.in2.desmos.domain.services.broker.adapter.factory.BrokerAdapterFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class BrokerEntityGetterServiceImpl implements BrokerEntityGetterService {
    private final BrokerAdapterService brokerAdapterService;

    public BrokerEntityGetterServiceImpl(BrokerAdapterFactory brokerAdapterFactory) {
        this.brokerAdapterService = brokerAdapterFactory.getBrokerAdapter();
    }

    @Override
    public Mono<List<MVBrokerEntity4DataNegotiation>> getMvBrokerEntities4DataNegotiation(String processId) {
        return brokerAdapterService.getMvBrokerEntities4DataNegotiation(processId);
    }
}