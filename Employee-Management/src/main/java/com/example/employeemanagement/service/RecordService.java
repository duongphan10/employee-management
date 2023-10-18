package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.request.RecordRequestDto;
import com.example.employeemanagement.domain.dto.response.RecordDto;

public interface RecordService {
    RecordDto getById(int id, int userId);
    RecordDto create(int userId, RecordRequestDto recordRequestDto);
}
