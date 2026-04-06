package com.ecommerce.portal.repository;

import com.ecommerce.portal.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
