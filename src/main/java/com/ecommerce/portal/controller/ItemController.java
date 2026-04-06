package com.ecommerce.portal.controller;

import com.ecommerce.portal.ItemService;
import com.ecommerce.portal.dto.ItemDTO;
import com.ecommerce.portal.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public void addProduct(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
    }

    @GetMapping
    public List<Item> getAll() {
        return itemService.getAllItem();
    }
}
