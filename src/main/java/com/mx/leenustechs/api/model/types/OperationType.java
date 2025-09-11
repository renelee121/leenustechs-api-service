package com.mx.leenustechs.api.model.types;

import com.mx.leenustechs.api.bussines.EventOperation;
import com.mx.leenustechs.api.model.PromptEvent;
import com.mx.leenustechs.api.model.response.PromptEventResponse;
import com.mx.leenustechs.api.service.OperationTypeService;

public enum OperationType {
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    RAIZ,
    EXPONENTE,
    FACTORIAL;

    public PromptEventResponse execute(PromptEvent PromptEvent, OperationTypeService operationTypeService){
        EventOperation operation = operationTypeService.getOperation(this);
        return operation.execute(PromptEvent);
    }
}
