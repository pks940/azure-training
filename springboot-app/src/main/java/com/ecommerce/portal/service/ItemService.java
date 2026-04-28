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

    @Autowired
    private BlobService blobService;

    public List<Item> getAllItems(){
        return  repository.findAll();
    }

    public void createItem(ItemDTO itemDTO) throws Exception {
        repository.save(mapToItemEntity(itemDTO));
    }

    private Item mapToItemEntity(ItemDTO dto) throws Exception {
        Item item = new Item();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setQuantity(dto.getQuantity());

        if (dto.getFile() != null) {
            String imageUrl = blobService.uploadFile(dto.getFile());
            item.setImageUrl(imageUrl);
        }

        return item;
    }
}
