package com.mx.leenustechs.api.bussines;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.api.model.PromptEvent;
import com.mx.leenustechs.api.model.response.PromptEventResponse;


@Service
public interface EventOperation {
    PromptEventResponse execute(PromptEvent event);
}
