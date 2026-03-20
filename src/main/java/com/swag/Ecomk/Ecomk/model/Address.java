package com.swag.Ecomk.Ecomk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Address_Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private  Long id;
    private  String stret;
    private  String city;
    private  String state;
    private  String country;
    private  String zipcode;

}
