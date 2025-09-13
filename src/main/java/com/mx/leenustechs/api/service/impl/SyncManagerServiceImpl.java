package com.mx.leenustechs.api.service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.leenustechs.api.bussines.utils.client.RestClientService;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.api.service.SyncManagerService;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Service
public class SyncManagerServiceImpl implements SyncManagerService {

    @Autowired
    private RestClientService restClientService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Mono<GenericEventObjectResponse> consultReactive(String transactionId) {
        Retry retry = Retry.fixedDelay(10, Duration.ofMillis(500))
                .filter(e -> e instanceof RuntimeException
                        && e.getMessage() != null
                        && e.getMessage().contains("Event not found"));

        return Mono.defer(() -> Mono.fromCallable(() -> {
            String json = restClientService.getDataFromService(transactionId);
            try {
                return objectMapper.readValue(json, GenericEventObjectResponse.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        })).retryWhen(retry);

    }

}
