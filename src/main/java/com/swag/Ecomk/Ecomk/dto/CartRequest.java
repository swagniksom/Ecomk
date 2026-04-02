package com.swag.Ecomk.Ecomk.dto;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class CartRequest {
    private  Long productId;
    private  Integer quantity;
}
