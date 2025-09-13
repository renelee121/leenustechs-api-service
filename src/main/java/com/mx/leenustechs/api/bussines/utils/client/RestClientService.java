package com.mx.leenustechs.api.bussines.utils.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class RestClientService {

    @Value("${external.service.url}")
    private String serviceUrl;

    private final HttpClient httpClient;

    public RestClientService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getDataFromService(String transactionId) {
        String url = String.format("%s/%s", serviceUrl, transactionId);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Error en GET: Status " + response.statusCode());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error ejecutando GET", e);
        }
    }
}
