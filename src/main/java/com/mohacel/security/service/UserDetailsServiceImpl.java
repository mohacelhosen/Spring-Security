package com.mohacel.security.service;

import com.mohacel.security.entity.UserEntity;
import com.mohacel.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        //without role verification
//        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());


        //if you have any rules like "student/ teacher/ staff/ admin"
        return new User(user.getEmail(), user.getPassword(), getAuthorities(user.getRoles()));
    }

    // to verify the rules and give the permission
    private Collection<? extends GrantedAuthority> getAuthorities(String roles) {
        List<SimpleGrantedAuthority> authorities = Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }
}

