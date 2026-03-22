package com.swag.Ecomk.Ecomk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  String description;
    private BigDecimal price;
    private Integer stockQuality;
    private String category;
    private String imageUrl;
    private Boolean active=true;
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private  LocalDateTime updateAt;
}
