package com.cronnoss.paymentsapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductsResponse {

    private Long id;
    private String accountId;
    private int balance;
    private String type;

    public ProductsResponse(Long id, String accountId, int balance, String type) {
        this.id = id;
        this.accountId = accountId;
        this.balance = balance;
        this.type = type;
    }
}