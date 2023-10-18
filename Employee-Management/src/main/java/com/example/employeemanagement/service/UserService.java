package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {

    UserDto getById(int userId);
    List<UserDto> getAllLeader();

}
