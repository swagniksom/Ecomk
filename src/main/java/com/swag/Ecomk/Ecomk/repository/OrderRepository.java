package com.swag.Ecomk.Ecomk.repository;

import com.swag.Ecomk.Ecomk.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
