package com.ecommerce.portal.service;

import com.ecommerce.portal.dto.ItemDTO;
import com.ecommerce.portal.entity.Item;
import com.ecommerce.portal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public List<Item> getAllItems(){
        return  repository.findAll();
    }

    public void createItem(ItemDTO itemDTO){
        repository.save(mapToItemEntity(itemDTO));
    }

    private Item mapToItemEntity(ItemDTO itemDTO){
        return Item.builder()
                .name(itemDTO.getName())
                .quantity(itemDTO.getQuantity())
                .price(itemDTO.getPrice())
                .build();
    }
}
