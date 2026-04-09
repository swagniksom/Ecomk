package com.swag.Ecomk.Ecomk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class OrdetItemDto {
    private Long id;
    private  Long productID;
    private  Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
}
