package com.cronnoss.springpostgres.dto;

import com.cronnoss.springpostgres.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductsResponse {
    private Long id;
    private String accountId;
    private int balance;
    private String type;

    public ProductsResponse(Product product) {
        this.id = product.getId();
        this.accountId = product.getAccountId();
        this.balance = product.getBalance();
        this.type = product.getType();
    }

    public ProductsResponse(ProductsResponse productsResponse) {
        this.id = productsResponse.getId();
        this.accountId = productsResponse.getAccountId();
        this.balance = productsResponse.getBalance();
        this.type = productsResponse.getType();
    }
}