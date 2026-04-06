package com.ecommerce.portal;

import com.ecommerce.portal.dto.ItemDTO;
import com.ecommerce.portal.entity.Item;
import com.ecommerce.portal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    public void addItem(ItemDTO itemDTO){
        itemRepository.save(mapToItemEntity(itemDTO));
    }

    public List<Item> getAllItem(){
       return itemRepository.findAll();
    }

    private Item mapToItemEntity(ItemDTO itemDTO){
        return Item.builder()
                .name(itemDTO.getName())
                .quantity(itemDTO.getQuantity())
                .price(itemDTO.getPrice())
                .build();
    }
}
