package com.swag.Ecomk.Ecomk.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductRequest {
    private  String name;
    private  String description;
    private BigDecimal price;
    private Integer stockQuality;
    private String category;
    private String imageUrl;
    private Boolean active=true;
}
