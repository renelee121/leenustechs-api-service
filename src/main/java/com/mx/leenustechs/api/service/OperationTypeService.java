package com.mx.leenustechs.api.service;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.api.bussines.EventOperation;
import com.mx.leenustechs.api.bussines.useCase.*;
import com.mx.leenustechs.api.model.types.OperationType;

@Service
public class OperationTypeService {

    private Map<OperationType, EventOperation> operationMap = new EnumMap<>(OperationType.class);

    public OperationTypeService(GenericEventUseCase genericEventUseCase) {
        operationMap.put(OperationType.SUMA, genericEventUseCase);
        operationMap.put(OperationType.RESTA, genericEventUseCase);
        operationMap.put(OperationType.MULTIPLICACION, genericEventUseCase);
        operationMap.put(OperationType.DIVISION, genericEventUseCase);
        operationMap.put(OperationType.EXPONENTE, genericEventUseCase);
        operationMap.put(OperationType.FACTORIAL, genericEventUseCase);
        operationMap.put(OperationType.RAIZ, genericEventUseCase);
    }

    public EventOperation getOperation(OperationType operationType){
        return operationMap.get(operationType);
    }
}
