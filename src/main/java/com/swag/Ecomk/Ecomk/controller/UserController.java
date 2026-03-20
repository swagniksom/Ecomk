package com.swag.Ecomk.Ecomk.controller;

import com.swag.Ecomk.Ecomk.dto.UserRequest;
import com.swag.Ecomk.Ecomk.dto.UserResponce;
import com.swag.Ecomk.Ecomk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
@Autowired
    private UserService userService;


@PostMapping("/api/create")
      public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest){
    userService.createUser(userRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);

}
@GetMapping("/api/user")
    public ResponseEntity<List<UserResponce>>getuser(){
    return  ResponseEntity.ok(userService.getUser());
}
//@PostMapping("api/updateuser")

}
