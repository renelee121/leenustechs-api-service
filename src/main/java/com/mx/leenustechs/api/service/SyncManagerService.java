package com.mx.leenustechs.api.service;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.api.model.response.GenericEventObjectResponse;

@Service
public interface SyncManagerService {
    public GenericEventObjectResponse consult(String transactionId);
}
