package com.ecommerce.portal.service;

import com.ecommerce.portal.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunctionClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String FUNCTION_URL =
            "https://<function-app>.azurewebsites.net/api/processOrder";

    public void sendOrder(Order order) {
        restTemplate.postForObject(FUNCTION_URL, order, String.class);
    }
}
