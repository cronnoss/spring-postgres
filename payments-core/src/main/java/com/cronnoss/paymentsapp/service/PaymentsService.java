package com.cronnoss.paymentsapp.service;

import com.cronnoss.paymentsapp.dto.ProductsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PaymentsService {

    private final RestTemplate restTemplate;

    public PaymentsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductsResponse getProduct(Long id) {
        return restTemplate.getForObject("http://localhost:8080/v1/products/" + id, ProductsResponse.class);
    }

    public List<ProductsResponse> getAllProducts(Long userId) {
        ProductsResponse[] productsArray = restTemplate.getForObject(
                "http://localhost:8080/v1/products/user/" + userId, ProductsResponse[].class);
        return productsArray != null ? Arrays.asList(productsArray) : Collections.emptyList();
    }

}
