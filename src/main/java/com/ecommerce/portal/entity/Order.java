package com.ecommerce.portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Order {

    @GeneratedValue
    @Id
    private int id;

    private int orderId;

    private String itemName;
    private int quantity;
}
