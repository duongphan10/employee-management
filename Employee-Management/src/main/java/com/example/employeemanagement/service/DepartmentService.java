package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.response.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAll();
}
