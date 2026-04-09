package com.swag.Ecomk.Ecomk.repository;

import com.swag.Ecomk.Ecomk.model.CartItem;
import com.swag.Ecomk.Ecomk.model.Product;
import com.swag.Ecomk.Ecomk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem,Long> {

    CartItem findByUserAndProduct(User user, Product product);

    void deleteByUserAndProduct(User user, Product product);
       List<CartItem> findByUser(User user);

    void deleteByUser(User user);
}
