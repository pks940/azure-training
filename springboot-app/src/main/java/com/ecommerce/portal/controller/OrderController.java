package com.ecommerce.portal.controller;

import com.ecommerce.portal.entity.Order;
import com.ecommerce.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order placeOrder(@RequestParam Long itemId,
                            @RequestParam int qty) {
        return service.placeOrder(itemId, qty);
    }
}
