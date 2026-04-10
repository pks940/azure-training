package com.ecommerce.portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/message")
    public String message() {
        return "App is running!";
    }
}
