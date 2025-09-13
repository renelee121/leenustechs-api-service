package com.mx.leenustechs.api.service;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;

import reactor.core.publisher.Mono;

@Service
public interface SyncManagerService {
    public Mono<GenericEventObjectResponse> consultReactive(String transactionId);
}
