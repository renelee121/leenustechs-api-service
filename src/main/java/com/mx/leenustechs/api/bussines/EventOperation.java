package com.mx.leenustechs.api.bussines;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.api.model.GenericEventObject;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;

import reactor.core.publisher.Mono;


@Service
public interface EventOperation {
    Mono<GenericEventObjectResponse> execute(GenericEventObject event);
}
