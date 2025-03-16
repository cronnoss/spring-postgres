package com.cronnoss.paymentsapp.controller;

import com.cronnoss.paymentsapp.dto.ProductsResponse;
import com.cronnoss.paymentsapp.service.PaymentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/payments")
public class PaymentsController {

    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping("/products/{id}")
    public ProductsResponse getProduct(@PathVariable Long id) {
        return paymentsService.getProduct(id);
    }

    @GetMapping("/products/user/{userId}")
    public List<ProductsResponse> getAllProducts(@PathVariable Long userId) {
        return paymentsService.getAllProducts(userId);
    }
}
