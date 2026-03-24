package com.swag.Ecomk.Ecomk.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CartRequest {
    private  Long productId;
    private  Integer quality;
}
