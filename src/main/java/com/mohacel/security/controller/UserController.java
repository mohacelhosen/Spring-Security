package com.mohacel.security.controller;

import com.mohacel.security.dto.UserDto;
import com.mohacel.security.exception.UserNotFoundException;
import com.mohacel.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl service;
    @GetMapping("/")
    public ResponseEntity<String> greeting(){
        String message = "Welcome the Word of Spring REST API";
        return  new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
        String registerInfo = service.registerUser(userDto);
        return  new ResponseEntity<>(registerInfo, HttpStatus.OK);
    }

    @GetMapping("/user/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> allUser(){
        List<UserDto> allUser = service.getAllUser();
        return  new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<UserDto> userById(@PathVariable Integer userId){
        UserDto userById = service.findUserById(userId);
        if (userById !=null){
            return new ResponseEntity<>(userById, HttpStatus.OK);
        }
        throw  new UserNotFoundException("Invalid Id");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        String message = "Your are eligible to 😏";
        return  new ResponseEntity<>(message, HttpStatus.OK);
    }
}
