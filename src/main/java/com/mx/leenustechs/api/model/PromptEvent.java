package com.mx.leenustechs.api.model;

import java.util.UUID;

import com.mx.leenustechs.api.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptEvent implements Event{
    private UUID transactionId;
    private OperationType operationType;
    private Number a;
    private Number b;
}

