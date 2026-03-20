package com.swag.Ecomk.Ecomk.repository;

import com.swag.Ecomk.Ecomk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
