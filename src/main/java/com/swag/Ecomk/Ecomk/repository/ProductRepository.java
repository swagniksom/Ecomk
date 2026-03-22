package com.swag.Ecomk.Ecomk.repository;

import com.swag.Ecomk.Ecomk.dto.ProductResponce;
import com.swag.Ecomk.Ecomk.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByActive();
}
