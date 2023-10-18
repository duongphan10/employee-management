package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.request.SalaryIncreaseCreateDto;
import com.example.employeemanagement.domain.dto.request.SalaryIncreaseUpdateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.SalaryIncreaseDto;

import java.util.List;

public interface SalaryIncreaseService {
    SalaryIncreaseDto getById(int id, int userId);
    List<SalaryIncreaseDto> getAllByUserId(int userId);
    SalaryIncreaseDto create(int userId, SalaryIncreaseCreateDto salaryIncreaseCreateDto);
    SalaryIncreaseDto update(int id, int userId, SalaryIncreaseUpdateDto salaryIncreaseUpdateDto);
    CommonResponseDto deleteById(int id, int userId);
}
