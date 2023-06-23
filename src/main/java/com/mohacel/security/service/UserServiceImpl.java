package com.mohacel.security.service;

import com.mohacel.security.dto.AddressDto;
import com.mohacel.security.dto.UserDto;
import com.mohacel.security.entity.AddressEntity;
import com.mohacel.security.entity.UserEntity;
import com.mohacel.security.exception.InappropriateDataException;
import com.mohacel.security.repository.AddressRepository;
import com.mohacel.security.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private PasswordEncoder passwordEncoder; // Add this line

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;

        this.addressRepository = addressRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Add this line
    }


    // register data will save into database
    public String registerUser(UserDto userDto){
        System.out.println(userDto);
        if (userRepository.findByEmail(userDto.getEmail()) != null){
            return "User Already Exist";
        }

        try {
            UserEntity user = new UserEntity();
            AddressEntity addressEntity = new AddressEntity();

            BeanUtils.copyProperties(userDto.getUserAddress(),addressEntity);
            user.setUserAddress(addressEntity);
            BeanUtils.copyProperties(userDto, user);

            if(userDto.getDesignation().equalsIgnoreCase("teacher")){
                user.setRoles("ROLE_TEACHER");
            } else if (userDto.getDesignation().equalsIgnoreCase("admin")) {
                user.setRoles("ROLE_ADMIN, ROLE_TEACHER, ROLE_USER");
            }else {
                user.setRoles("ROLE_USER");
            }


            // Hash the password using Bcrypt
            String hashedPassword  = passwordEncoder.encode(userDto.getPassword());
            user.setPassword(hashedPassword );

            Integer userId = userRepository.save(user).getUserId();
            System.out.println(user);
            if(userId != null){
                return "Registration Successful";
            }else{
                return "Something is wrong!";
            }
        }catch (Exception e){
            throw  new InappropriateDataException(e.getMessage());
        }
    }


    // retrieve the all the user
    public List<UserDto> getAllUser(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for(UserEntity entity:userEntities){
            UserDto userDto = new UserDto();
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(entity.getUserAddress(), addressDto);
            BeanUtils.copyProperties(entity,userDto);
            userDto.setUserAddress(addressDto);
            userDtoList.add(userDto);
        }
        return  userDtoList;
    }

    @Override
    public UserDto findUserById(Integer userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        UserDto dtoUser = new UserDto();
        AddressDto dtoAddress = new AddressDto();
        if (user.isPresent()){
            BeanUtils.copyProperties(user.get().getUserAddress(),dtoAddress);
            dtoUser.setUserAddress(dtoAddress);
            BeanUtils.copyProperties(user, dtoUser);
            return  dtoUser;
        }
        return null;
    }

}
