package com.cronnoss.springpostgres.service;

import com.cronnoss.springpostgres.entities.Item;
import com.cronnoss.springpostgres.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Item not found with id: " + id));
    }

    public List<Item> getAllItems(Long userId) {
        return itemRepository.findAllByUserId(userId);
    }
}
