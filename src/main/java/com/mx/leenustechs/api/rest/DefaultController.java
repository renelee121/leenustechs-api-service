package com.mx.leenustechs.api.rest;

import org.springframework.web.bind.annotation.RestController;

import com.mx.leenustechs.api.dto.GenericEventObjectDto;
import com.mx.leenustechs.api.model.request.GenericEventObjectRequest;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.api.service.OperationTypeService;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class DefaultController {

    @Autowired
    OperationTypeService operationTypeService;

    @PostMapping("/calculadora")
    public Mono<GenericEventObjectResponse> calculadora(@RequestBody GenericEventObjectRequest request) {
        GenericEventObjectDto dto = new GenericEventObjectDto(request);
        return dto.getOperationType().execute(dto.toModel(), operationTypeService);
    }
    
}
