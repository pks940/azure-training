package com.ecommerce.portal.controller;

import com.ecommerce.portal.dto.ItemDTO;
import com.ecommerce.portal.entity.Item;
import com.ecommerce.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemUIController {

    @Autowired
    private ItemService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", new Item());
        return "index";
    }

    @GetMapping("/item")
    public String getItemPage(Model model) {
        model.addAttribute("items", service.getAllItems()); // <-- add this
        return "item";
    }

    @PostMapping("/item")
    public String createItem(@ModelAttribute ItemDTO item) throws Exception {
        service.createItem(item);
        return "redirect:/item";
    }
}