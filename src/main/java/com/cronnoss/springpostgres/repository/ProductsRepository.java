package com.cronnoss.springpostgres.repository;

import com.cronnoss.springpostgres.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    // getProduct
    Optional<Product> findById(Long id);

    // getAllProducts by userId
    List<Product> findAllByUserId(Long userId);
}
