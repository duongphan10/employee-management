package com.example.employeemanagement.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.employeemanagement.domain.dto.request.EmployeeProfileRequestDto;
import com.example.employeemanagement.domain.dto.request.EmployeeRequestFileDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAll(int userId);

    EmployeeDto getById(int id, int userId);

    EmployeeDto create(MultipartFile file, EmployeeProfileRequestDto employeeProfileRequestDto, int userId);

    EmployeeDto updateById(int id, EmployeeRequestFileDto employeeRequestFileDto, int userId);

    CommonResponseDto deleteById(int id, int userId);

}
