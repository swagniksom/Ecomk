package com.swag.Ecomk.Ecomk.service;

import com.swag.Ecomk.Ecomk.dto.ProductRequest;
import com.swag.Ecomk.Ecomk.dto.ProductResponce;
import com.swag.Ecomk.Ecomk.model.Product;
import com.swag.Ecomk.Ecomk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository respository;
    public ProductResponce createProduct(ProductRequest productRequest) {
        Product product=new Product();
        updateProductRequest(product,productRequest);
        Product  saveProduct= respository.save(product);
        return  mapToResponce(saveProduct);
    }

    private ProductResponce mapToResponce(Product saveProduct) {
        ProductResponce responce=new ProductResponce();
        responce.setId(saveProduct.getId());
        responce.setName(saveProduct.getName());
        responce.setDescription(saveProduct.getDescription());
        responce.setCategory(saveProduct.getCategory());
        responce.setActive(saveProduct.getActive());
        responce.setPrice(saveProduct.getPrice());
        responce.setImageUrl(saveProduct.getImageUrl());
        responce.setStockQuality(saveProduct.getStockQuality());
        return responce;
    }

    private void updateProductRequest(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setCategory(productRequest.getCategory());
        product.setActive(productRequest.getActive());
        product.setPrice(productRequest.getPrice());
        product.setImageUrl(productRequest.getImageUrl());
        product.setStockQuality(product.getStockQuality());
    }

    public List<ProductResponce> getAllProducts() {
        return respository.findByActive().stream().map(this::mapToResponce).collect(Collectors.toList());

    }

    public Optional<ProductResponce> updateProduct(Long id, ProductRequest productRequest) {
        return respository.findById(id).map(exitingProduct->{
            updateProductRequest(exitingProduct,productRequest);

            Product updatedProduct=respository.save(exitingProduct);
            return mapToResponce(updatedProduct);
        });
    }
}
