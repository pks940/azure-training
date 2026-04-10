package com.ecommerce.portal.service;

import com.ecommerce.portal.entity.Item;
import com.ecommerce.portal.entity.Order;
import com.ecommerce.portal.repository.ItemRepository;
import com.ecommerce.portal.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private FunctionClient functionClient;

    public Order placeOrder(Long itemId, int qty) {

        Item item = itemRepo.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (item.getQuantity() < qty) {
            throw new RuntimeException("Out of stock");
        }

        // reduce stock
        item.setQuantity(item.getQuantity() - qty);
        itemRepo.save(item);

        Order order = new Order();
        order.setItemId(itemId);
        order.setQuantity(qty);
        order.setTotalPrice(item.getPrice() * qty);
        order.setStatus("CREATED");

        Order saved = orderRepo.save(order);

        // async call
        functionClient.sendOrder(saved);

        return saved;
    }
}
