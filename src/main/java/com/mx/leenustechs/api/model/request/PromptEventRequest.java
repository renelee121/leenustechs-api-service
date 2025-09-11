package com.mx.leenustechs.api.model.request;

import com.mx.leenustechs.api.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptEventRequest{
    private OperationType operationType;
    private Number a;
    private Number b;
}
