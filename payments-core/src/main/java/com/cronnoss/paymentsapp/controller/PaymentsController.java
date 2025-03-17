package com.cronnoss.paymentsapp.controller;

import com.cronnoss.paymentsapp.dto.PaymentRequest;
import com.cronnoss.paymentsapp.dto.ProductsResponse;
import com.cronnoss.paymentsapp.service.PaymentsService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{userId}/products")
    public List<ProductsResponse> getAllProducts(@PathVariable Long userId) {
        return paymentsService.getAllProducts(userId);
    }

    @PostMapping("/user/{userId}/products/{id}/pay")
    public String payForProduct(
            @PathVariable Long userId,
            @PathVariable Long id,
            @RequestBody PaymentRequest paymentRequest) {
        Integer amount = paymentRequest.getAmount();
        return paymentsService.payForProduct(userId, id, amount);
    }
}
