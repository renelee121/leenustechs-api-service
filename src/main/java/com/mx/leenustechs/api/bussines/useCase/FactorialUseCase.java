package com.mx.leenustechs.api.bussines.useCase;

import org.springframework.stereotype.Component;

import com.mx.leenustechs.api.bussines.EventOperation;
import com.mx.leenustechs.api.dto.PromptEventDto;
import com.mx.leenustechs.api.model.PromptEvent;
import com.mx.leenustechs.api.model.response.PromptEventResponse;

@Component
public class FactorialUseCase implements EventOperation{

    @Override
    public PromptEventResponse execute(PromptEvent event) {
        PromptEventDto dto = new PromptEventDto(event);
        Number a = dto.getA();
        long result = 1;
        for (long i = 2; i <= a.longValue(); i++) {
            result *= i;
        }
        return  dto.toResponse(result);
    }

}
