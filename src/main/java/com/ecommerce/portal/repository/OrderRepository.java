package com.ecommerce.portal.repository;

import com.ecommerce.portal.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
