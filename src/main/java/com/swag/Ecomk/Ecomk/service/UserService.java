package com.swag.Ecomk.Ecomk.service;


import com.swag.Ecomk.Ecomk.dto.AddressDto;
import com.swag.Ecomk.Ecomk.dto.UserRequest;
import com.swag.Ecomk.Ecomk.dto.UserResponce;
import com.swag.Ecomk.Ecomk.model.Address;
import com.swag.Ecomk.Ecomk.model.User;
import com.swag.Ecomk.Ecomk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
@Autowired
    private  UserRepository userRepository;



    public String createUser(UserRequest userRequest){
        User user=new User();
        UpdateUserFromRequest(user,userRequest);
        userRepository.save(user);
        return  "User reated Successfully";

    }
public List<UserResponce> getUser(){
        return  userRepository.findAll().stream().map(this::maptoResponce).collect(Collectors.toList());
}
    public Boolean UpdateUser(Long id, UserRequest updateuserRequest) {
        return userRepository.findById(id).map(exituser->{
            UpdateUserFromRequest(exituser,updateuserRequest);
            userRepository.save(exituser);
            return true;
        }).orElse(false);

    }

    private UserResponce maptoResponce(User user) {
        UserResponce userResponce=new UserResponce();
        userResponce.setId(user.getId());
        userResponce.setFirstname(user.getFirstname());
        userResponce.setLastname(user.getLastname());
        userResponce.setEmail(user.getEmail());
        userResponce.setPhonenumber(user.getPhonenumber());
        userResponce.setUserRole(user.getRole());
        if(user.getAddress()!=null){
            AddressDto addressDto=new AddressDto();
//            addressDto.setId(user.getAddress().getId());
            addressDto.setStret(user.getAddress().getStret());
            addressDto.setCity(user.getAddress().getCity());
            addressDto.setState(user.getAddress().getState());
            addressDto.setCountry(user.getAddress().getCountry());
            addressDto.setZipcode(user.getAddress().getZipcode());
            userResponce.setAddress(addressDto);
        }
             return userResponce;
    }

    private void UpdateUserFromRequest(User user, UserRequest userRequest) {
//        user.setId(userRequest.getId());
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setEmail(userRequest.getEmail());
        user.setPhonenumber(userRequest.getPhonenumber());
        user.setRole(userRequest.getUserRole());
       if(userRequest.getAddress()!=null){
           Address address=new Address();
//           address.setId(userRequest.getAddress().getId());
           address.setStret(userRequest.getAddress().getStret());
           address.setCity(userRequest.getAddress().getCity());
           address.setState(userRequest.getAddress().getState());
           address.setCountry(userRequest.getAddress().getCountry());
           address.setZipcode(userRequest.getAddress().getZipcode());
           user.setAddress(address);

       }
    }

public Optional<UserResponce> getParticularUser(Long id){
        return userRepository.findById(id).map(this::maptoResponce);
}
}
