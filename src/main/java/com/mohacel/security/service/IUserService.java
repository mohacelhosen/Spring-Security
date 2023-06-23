package com.mohacel.security.service;

import com.mohacel.security.dto.UserDto;

import java.util.List;

public interface IUserService {
    public String registerUser(UserDto userDto);
    public List<UserDto> getAllUser();

    public UserDto findUserById(Integer userId);
}
