package com.mx.leenustechs.api.rest;

import org.springframework.web.bind.annotation.RestController;

import com.mx.leenustechs.api.dto.PromptEventDto;
import com.mx.leenustechs.api.model.request.PromptEventRequest;
import com.mx.leenustechs.api.model.response.PromptEventResponse;
import com.mx.leenustechs.api.service.OperationTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class DefaultController {

    @Autowired
    OperationTypeService operationTypeService;

    @PostMapping("/calculadora")
    public PromptEventResponse calculadora(@RequestBody PromptEventRequest request) {
        PromptEventDto dto = new PromptEventDto(request);
        return dto.getOperationType().execute(dto.toModel(), operationTypeService);
    }
    
}
