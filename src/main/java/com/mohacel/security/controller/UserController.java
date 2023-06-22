package com.mohacel.security.controller;

import com.mohacel.security.dto.UserDto;
import com.mohacel.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;
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
    public ResponseEntity<List<UserDto>> allUser(){
        List<UserDto> allUser = service.getAllUser();
        return  new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        String message = "Your are eligible to 😏";
        return  new ResponseEntity<>(message, HttpStatus.OK);
    }
}
