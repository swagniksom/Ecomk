package com.swag.Ecomk.Ecomk.dto;

import com.swag.Ecomk.Ecomk.model.UserRole;
import lombok.Data;

@Data
public class UserResponce {
    private Long id;
    private String firstname;
    private  String lastname;
    private String email;
    private String phonenumber;
    private UserRole userRole;
    private AddressDto address;
}
