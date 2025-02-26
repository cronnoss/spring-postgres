package com.cronnoss.springpostgres.repository;

import com.cronnoss.springpostgres.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    // getItem
    Optional<Item> findById(Long id);

    // getAllItems by userId
    List<Item> findAllByUserId(Long userId);
}
