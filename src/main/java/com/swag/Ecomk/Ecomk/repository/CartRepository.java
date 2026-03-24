package com.swag.Ecomk.Ecomk.repository;

import com.swag.Ecomk.Ecomk.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem,Long> {

}
