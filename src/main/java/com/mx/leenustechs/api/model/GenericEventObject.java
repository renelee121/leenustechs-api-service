package com.mx.leenustechs.api.model;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.mx.leenustechs.api.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEventObject implements Event{
    private UUID transactionId;
    private OperationType operationType;
    private JsonNode payload;
}

