//package com.ecommerce.portal.controller;
//
//import com.ecommerce.portal.dto.ItemDTO;
//import com.ecommerce.portal.entity.Item;
//import com.ecommerce.portal.service.ItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/item")
//public class ItemController {
//
//    @Autowired
//    private ItemService service;
//
//    @GetMapping
//    public List<Item> getAllItems(){
//        return service.getAllItems();
//    }
//
//    @PostMapping
//    public void createItem(@RequestBody ItemDTO itemDTO) {
//        service.createItem(itemDTO);
//    }
//}
