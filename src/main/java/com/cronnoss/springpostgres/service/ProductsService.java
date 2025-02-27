package com.cronnoss.springpostgres.service;

import com.cronnoss.springpostgres.dto.ProductsResponse;
import com.cronnoss.springpostgres.entities.Product;
import com.cronnoss.springpostgres.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsResponse getProduct(Long id) {
        Product product = productsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found with id: " + id));
        return new ProductsResponse(product);
    }

    public List<ProductsResponse> getAllProducts(Long userId) {
        List<Product> products = productsRepository.findAllByUserId(userId);
        return products.stream().map(ProductsResponse::new).collect(Collectors.toList());
    }
}
