package com.cronnoss.springpostgres.controller;

import com.cronnoss.springpostgres.dto.ProductsResponse;
import com.cronnoss.springpostgres.entities.ErrorResponse;
import com.cronnoss.springpostgres.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/{id}")
    public ProductsResponse getProduct(@PathVariable Long id) {
        return productsService.getProduct(id);
    }

    @GetMapping("/user/{userId}")
    public List<ProductsResponse> getAllProducts(@PathVariable Long userId) {
        return productsService.getAllProducts(userId);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse("An error occurred: " + e.getMessage());
    }
}
