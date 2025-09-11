package com.mx.leenustechs.api.dto;

import java.util.UUID;

import com.mx.leenustechs.api.model.PromptEvent;
import com.mx.leenustechs.api.model.request.PromptEventRequest;
import com.mx.leenustechs.api.model.response.PromptEventResponse;
import com.mx.leenustechs.api.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptEventDto {
    private UUID transactionId;
    private OperationType operationType;
    private Number a;
    private Number b;

    public PromptEventDto(PromptEvent event){
        this.transactionId = event.getTransactionId();
        this.operationType = event.getOperationType();
        this.a = event.getA();
        this.b = event.getB();
    }

    public PromptEvent toModel(){
        return new PromptEvent(
            this.transactionId,
            this.operationType,
            this.a,
            this.b
        );
    }

    public PromptEventDto(PromptEventRequest event){
        this.transactionId = UUID.randomUUID();
        this.operationType = event.getOperationType();
        this.a = event.getA();
        this.b = event.getB();
    }

    public PromptEventRequest toRequest(){
        return new PromptEventRequest(
            this.operationType,
            this.a,
            this.b
        );
    }

    public PromptEventDto(PromptEventResponse event){
        this.transactionId = UUID.randomUUID();
        this.operationType = event.getOperationType();
        this.a = event.getA();
        this.b = event.getB();
    }

    public PromptEventResponse toResponse(Number response){
        return new PromptEventResponse(
            this.transactionId,
            this.operationType,
            this.a,
            this.b,
            response
        );
    }

}
