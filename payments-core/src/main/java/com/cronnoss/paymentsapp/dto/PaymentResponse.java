package com.cronnoss.paymentsapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {

    private String message;

    public PaymentResponse(String message) {
        this.message = message;
    }
}
