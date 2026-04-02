package com.swag.Ecomk.Ecomk.controller;


import com.swag.Ecomk.Ecomk.dto.CartRequest;
import com.swag.Ecomk.Ecomk.dto.CartResonce;
import com.swag.Ecomk.Ecomk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

@PostMapping
    public ResponseEntity<String> addToCart(@RequestHeader("X-USER-ID") String userId,@RequestBody CartRequest request){
    if(!cartService.addToCart(userId,request)){
        return  ResponseEntity.badRequest().body("Product out of stock or user not found or product not found");
    }

return ResponseEntity.status(HttpStatus.CREATED).build();
}

@DeleteMapping("/deleteitem")
public  ResponseEntity<Void> removeFromCart(
    @RequestHeader("X-USER-ID")  String userID,
    @PathVariable Long productId
){
boolean  deleted=cartService.deleteItemFromCart(userID,productId);
return deleted ?ResponseEntity.noContent().build() :ResponseEntity.notFound().build();
}
}
