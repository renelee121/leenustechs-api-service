package com.mx.leenustechs.api.model.types;

import com.mx.leenustechs.api.bussines.EventOperation;
import com.mx.leenustechs.api.model.GenericEventObject;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.api.service.OperationTypeService;

import reactor.core.publisher.Mono;

public enum OperationType {
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    RAIZ,
    EXPONENTE,
    FACTORIAL;

    public Mono<GenericEventObjectResponse> execute(GenericEventObject GenericEventObject, OperationTypeService operationTypeService){
        EventOperation operation = operationTypeService.getOperation(this);
        return operation.execute(GenericEventObject);
    }
}
