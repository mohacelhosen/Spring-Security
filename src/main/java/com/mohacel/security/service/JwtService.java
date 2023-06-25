package com.mohacel.security.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Service
public class JwtService {

    private String generateToken(String email){
        Map<String, Objects>  claims= new HashMap<>();

        return createToken(claims, email);
    }

    private String createToken(Map<String, Objects> claims, String email) {
        return null;
    }
}
