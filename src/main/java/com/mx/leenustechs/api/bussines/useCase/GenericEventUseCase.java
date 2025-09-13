package com.mx.leenustechs.api.bussines.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.leenustechs.api.bussines.EventOperation;
import com.mx.leenustechs.api.dto.GenericEventObjectDto;
import com.mx.leenustechs.api.model.GenericEventObject;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.api.service.ProducerService;
import com.mx.leenustechs.api.service.SyncManagerService;

import reactor.core.publisher.Mono;

@Component
public class GenericEventUseCase implements EventOperation {

    @Autowired
    public ProducerService producerService;

    @Autowired
    public SyncManagerService syncManagerService;

    @Override
    public Mono<GenericEventObjectResponse> execute(GenericEventObject event) {
        GenericEventObjectDto dto = new GenericEventObjectDto(event);
        producerService.sendMessage(dto.getTransactionId().toString(), dto.toModel());
        return  syncManagerService.consultReactive(dto.getTransactionId().toString());
    }
    
}
