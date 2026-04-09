package com.swag.Ecomk.Ecomk.controller;

import com.swag.Ecomk.Ecomk.dto.OrderResponce;
import com.swag.Ecomk.Ecomk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponce> createOrder(@RequestHeader("X-USER-ID") String userId){
Optional<OrderResponce> order=orderService.createOrder(userId);
return orderService.createOrder(userId).map(orderResponce -> new ResponseEntity<>(orderResponce,HttpStatus.CREATED)).orElseGet(()->ResponseEntity.badRequest().build());

    }
}
