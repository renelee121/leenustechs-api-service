package com.mx.leenustechs.api.bussines.useCase;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

import com.mx.leenustechs.api.bussines.EventOperation;
import com.mx.leenustechs.api.dto.GenericEventObjectDto;
import com.mx.leenustechs.api.model.GenericEventObject;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;

@Component
public class ExponencialUseCase implements EventOperation{

    @Override
    public GenericEventObjectResponse execute(GenericEventObject event) {
        GenericEventObjectDto dto = new GenericEventObjectDto(event);
        JsonNode payload = dto.getPayload();
        Number a = payload.get("a").asDouble();
        Number b = payload.get("b").asDouble();
        Number response = Math.pow(a.doubleValue(), b.doubleValue());
        return dto.toResponse(response);
    }

}
