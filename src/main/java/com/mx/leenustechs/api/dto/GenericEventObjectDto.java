package com.mx.leenustechs.api.dto;

import java.util.UUID;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mx.leenustechs.api.model.GenericEventObject;
import com.mx.leenustechs.api.model.request.GenericEventObjectRequest;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.api.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEventObjectDto {
    private UUID transactionId;
    private OperationType operationType;
    private JsonNode payload;

    public GenericEventObjectDto(GenericEventObject event){
        this.transactionId = event.getTransactionId();
        this.operationType = event.getOperationType();
        this.payload = event.getPayload();
    }

    public GenericEventObject toModel(){
        return new GenericEventObject(
            this.transactionId,
            this.operationType,
            this.payload
        );
    }

    public GenericEventObjectDto(GenericEventObjectRequest event){
        this.transactionId = UUID.randomUUID();
        this.operationType = event.getOperationType();
        this.payload = event.getPayload();
    }

    public GenericEventObjectRequest toRequest(){
        return new GenericEventObjectRequest(
            this.operationType,
            this.payload
        );
    }

    public GenericEventObjectDto(GenericEventObjectResponse event){
        this.transactionId = UUID.randomUUID();
        this.operationType = event.getOperationType();
        this.payload = event.getPayload();
    }

    public GenericEventObjectResponse toResponse(Number response){
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.putPOJO("response", response);
        return new GenericEventObjectResponse(
            this.transactionId,
            this.operationType,
            objectNode
        );
    }

}
