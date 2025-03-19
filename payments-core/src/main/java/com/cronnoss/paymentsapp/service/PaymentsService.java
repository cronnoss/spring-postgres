package com.cronnoss.paymentsapp.service;

import com.cronnoss.paymentsapp.dto.PaymentResponse;
import com.cronnoss.paymentsapp.dto.ProductsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PaymentsService {

    private final String getProductByIdMethod;
    private final String getUsersProductsMethod;
    private final RestTemplate restTemplate;

    public PaymentsService(@Value("${service.get-product-by-id}") String getProductByIdMethod,
                           @Value("${service.get-users-products}") String getUsersProductsMethod,
                           RestTemplate restTemplate
    ) {
        this.getProductByIdMethod = getProductByIdMethod;
        this.getUsersProductsMethod = getUsersProductsMethod;
        this.restTemplate = restTemplate;
    }

    public ProductsResponse getProduct(Long id) {
        return restTemplate.getForObject(getProductByIdMethod + id, ProductsResponse.class);
    }

    public List<ProductsResponse> getAllProducts(Long userId) {
        ProductsResponse[] productsArray = restTemplate.getForObject(
                getUsersProductsMethod + userId, ProductsResponse[].class);
        return productsArray != null ? Arrays.asList(productsArray) : Collections.emptyList();
    }

    public PaymentResponse payForProduct(Long userId, Long id, Integer amount) {
        ProductsResponse product = getProduct(id);
        if (product == null) {
            return new PaymentResponse("Product not found");
        }
        if (product.getBalance() < amount) {
            return new PaymentResponse("Insufficient funds");
        }
        return new PaymentResponse("Payment successful");
    }
}
