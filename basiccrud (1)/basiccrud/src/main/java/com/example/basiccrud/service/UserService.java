package com.example.basiccrud.service;

import com.example.basiccrud.dto.UserDto;
import com.example.basiccrud.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    List<UserDto> getUser();

    UserDto getUser(Long id);

    UserDto updateUser(Long id, UserDto user);

    Boolean deleteUser(Long id);
}
