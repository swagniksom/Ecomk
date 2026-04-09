package com.swag.Ecomk.Ecomk.dto;

import com.swag.Ecomk.Ecomk.model.OrderItem;
import com.swag.Ecomk.Ecomk.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
//@AllArgsConstructor
public class OrderResponce {
    private Long id;
    private BigDecimal totalAmout;
    private OrderStatus status;
    private List<OrdetItemDto> items;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public OrderResponce(Long id, List<OrderItem> items, OrderStatus status, BigDecimal totalAmount, List<OrdetItemDto> collect, LocalDateTime createdAt) {
    }
}
