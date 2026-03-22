package com.swag.Ecomk.Ecomk.controller;


import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.swag.Ecomk.Ecomk.dto.ProductRequest;
import com.swag.Ecomk.Ecomk.dto.ProductResponce;
import com.swag.Ecomk.Ecomk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<ProductResponce>createProduct(@RequestBody ProductRequest productRequest){
        return new  ResponseEntity<ProductResponce>(productService.createProduct(productRequest),HttpStatus.CREATED);
    }
@GetMapping
    public ResponseEntity<List<ProductResponce>> getAllPrduct(){
        return ResponseEntity.of(productService.getAllProducts());
}
@PutMapping("/{id}")
    public ResponseEntity<ProductResponce>updateProduct(@PathVariable Long id,@RequestBody ProductRequest productRequest){
        return productService.updateProduct(id,productRequest).
}
@DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long id){
productService.deleteProduct(id);
return ResponseEntity.noContent().build();
}

}
