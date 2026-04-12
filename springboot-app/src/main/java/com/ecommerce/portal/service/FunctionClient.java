package com.ecommerce.portal.service;

import com.ecommerce.portal.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunctionClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String FUNCTION_URL = System.getenv("FUNCTION_URL");
    public String sendOrder(Object order) throws Exception {

        String url = System.getenv("FUNCTION_URL");

        RestTemplate restTemplate = new RestTemplate();

        // Convert object → JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(order);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        // Call function
        return restTemplate.postForObject(url, request, String.class);
    }
}
