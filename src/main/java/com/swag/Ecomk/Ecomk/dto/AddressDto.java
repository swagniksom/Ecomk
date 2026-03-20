package com.swag.Ecomk.Ecomk.dto;

import lombok.Data;

@Data
public class AddressDto {
    private  Long id;
    private  String stret;
    private  String city;
    private  String state;
    private  String country;
    private  String zipcode;
}
