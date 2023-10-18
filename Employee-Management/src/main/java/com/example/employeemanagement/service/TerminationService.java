package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.request.TerminationCreateDto;
import com.example.employeemanagement.domain.dto.request.TerminationUpdateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.TerminationDto;

import java.util.List;

public interface TerminationService {
    TerminationDto getById(int id, int userId);

    List<TerminationDto> getALlByUserId(int userId);

    TerminationDto create(int userId, TerminationCreateDto terminationCreateDto);

    TerminationDto update(int id, int userId, TerminationUpdateDto terminationUpdateDto);

    CommonResponseDto deleteById(int id, int userId);
}
