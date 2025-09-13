package com.mx.leenustechs.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.leenustechs.api.bussines.utils.client.RestClientService;
import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.api.service.SyncManagerService;

@Service
public class SyncManagerServiceImpl implements SyncManagerService {

    @Autowired
    private RestClientService restClientService;

    @Override
    public GenericEventObjectResponse consult(String transactionId) {
        String response = restClientService.getDataFromService(transactionId);
        ObjectMapper mapper = new ObjectMapper();
        GenericEventObjectResponse eventResponse = null;
        try {
            eventResponse = mapper.readValue(response, GenericEventObjectResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
        return eventResponse;
    }

}
