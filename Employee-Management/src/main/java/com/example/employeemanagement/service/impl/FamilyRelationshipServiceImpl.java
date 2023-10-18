package com.example.employeemanagement.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.MessageConstant;
import com.example.employeemanagement.domain.dto.request.FamilyRelationshipRequestDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.FamilyRelationshipDto;
import com.example.employeemanagement.exception.JsonException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.FamilyRelationshipService;
import com.example.employeemanagement.util.JsonUtil;
import com.example.employeemanagement.validator.FamilyRelationshipValidator;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {

    private final EntityManager entityManager;
    private final EmployeeService employeeService;
    private final FamilyRelationshipValidator familyRelationshipValidator;

    @Override
    public List<FamilyRelationshipDto> getAllByEmployeeId(int employeeId, int userId) {
        employeeService.getById(employeeId, userId);

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllFamilyRelationshipByEmployeeId", "FamilyRelationshipMapper")
                .registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN)
                .setParameter("employeeId", employeeId);
        storedProcedureQuery.execute();
        return (List<FamilyRelationshipDto>) storedProcedureQuery.getResultList();
    }

    @Override
    public FamilyRelationshipDto getById(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetFamilyRelationshipById", "FamilyRelationshipMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new NotFoundException(ErrorMessage.FamilyRelationship.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});
        }
        familyRelationshipValidator.checkPermissionGet(id, userId);

        return (FamilyRelationshipDto) storedProcedureQuery.getSingleResult();
    }

    @Override
    public List<FamilyRelationshipDto> create(int userId, int employeeId, List<FamilyRelationshipRequestDto> familyRelationshipRequestDtos) {
        EmployeeDto employeeDto = employeeService.getById(employeeId, userId);
        familyRelationshipValidator.checkPermissionCreate(userId, employeeDto);
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CreateFamilyRelationship", "FamilyRelationshipMapper")
                    .registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("familyRelationshipJson", String.class, ParameterMode.IN)
                    .setParameter("employeeId", employeeId)
                    .setParameter("familyRelationshipJson", JsonUtil.toJson(familyRelationshipRequestDtos));
            return (List<FamilyRelationshipDto>) storedProcedureQuery.getResultList();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public FamilyRelationshipDto updateById(int id, FamilyRelationshipRequestDto familyRelationshipRequestDto, int userId) {
        FamilyRelationshipDto familyRelationshipDto = this.getById(id, userId);
        familyRelationshipValidator.checkPermissionUpdate(familyRelationshipDto.getEmployeeProfileId(), userId);

        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_UpdateFamilyRelationshipById", "FamilyRelationshipMapper")
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("familyRelationshipJson", String.class, ParameterMode.IN)
                    .setParameter("id", id)
                    .setParameter("familyRelationshipJson", JsonUtil.toJson(familyRelationshipRequestDto));
            return (FamilyRelationshipDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public CommonResponseDto deleteById(int id, int userId) {
        FamilyRelationshipDto familyRelationshipDto = this.getById(id, userId);
        familyRelationshipValidator.checkPermissionDelete(familyRelationshipDto.getEmployeeProfileId(), userId);

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_DeleteFamilyRelationshipById")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        return new CommonResponseDto(true, MessageConstant.DELETE_FAMILY_RELATIONSHIP_SUCCESSFULLY);
    }
}
