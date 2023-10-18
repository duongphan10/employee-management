package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.request.FamilyRelationshipRequestDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.FamilyRelationshipDto;

import java.util.List;

public interface FamilyRelationshipService {
    List<FamilyRelationshipDto> getAllByEmployeeId(int employeeId, int userId);

    FamilyRelationshipDto getById(int id, int userId);

    List<FamilyRelationshipDto> create(int userId, int employeeId, List<FamilyRelationshipRequestDto> familyRelationshipRequestDtos);

    FamilyRelationshipDto updateById(int id, FamilyRelationshipRequestDto familyRelationshipRequestDto, int userId);

    CommonResponseDto deleteById(int id, int userId);
}
