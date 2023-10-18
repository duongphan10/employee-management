package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.response.PositionDto;

import java.util.List;

public interface PositionService {
    List<PositionDto> getAll();
}
