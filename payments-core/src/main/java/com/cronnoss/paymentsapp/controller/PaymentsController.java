package com.cronnoss.paymentsapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/payments")
public class PaymentsController {

    private final RestTemplate restTemplate;

    public PaymentsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8080/v1/products/" + id, String.class);
    }

    @GetMapping("/products/user/{userId}")
    public String getAllProducts(@PathVariable Long userId) {
        return restTemplate.getForObject("http://localhost:8080/v1/products/user/" + userId, String.class);
    }
}
