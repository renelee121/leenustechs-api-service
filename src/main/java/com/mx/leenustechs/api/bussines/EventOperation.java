package com.mx.leenustechs.api.bussines;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.api.model.GenericEventObject;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;


@Service
public interface EventOperation {
    GenericEventObjectResponse execute(GenericEventObject event);
}
