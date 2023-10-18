package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.request.RegistrationCreateDto;
import com.example.employeemanagement.domain.dto.request.RegistrationUpdateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.RegistrationDto;

import java.util.List;

public interface RegistrationService {
    RegistrationDto getById(int id, int userId);
    List<RegistrationDto> getAllByUserId(int userId);
    RegistrationDto create(int userId, RegistrationCreateDto registrationCreateDto);
    RegistrationDto update(int id, int userId, RegistrationUpdateDto registrationUpdateDto);
    CommonResponseDto deleteById(int id, int userId);
}
