package com.swag.Ecomk.Ecomk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;

@Entity(name="User_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private  String lastname;
    private String email;
    private String phonenumber;
    private UserRole role=UserRole.CUSTOMER;
    @OneToOne(cascade =CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "Address_id",referencedColumnName = "id")
    private  Address address;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private  LocalDateTime UpdatedAt;
}
