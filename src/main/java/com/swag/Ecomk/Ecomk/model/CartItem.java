package com.swag.Ecomk.Ecomk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity(name = "CartItem")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "User_id",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "Product_id",nullable = false)
    private Product product;
    private  Integer quantity;
    private BigDecimal price;

}
