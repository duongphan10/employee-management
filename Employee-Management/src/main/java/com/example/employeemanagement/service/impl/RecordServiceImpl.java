package com.example.employeemanagement.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.domain.dto.request.RecordRequestDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.RecordDto;
import com.example.employeemanagement.exception.JsonException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.RecordService;
import com.example.employeemanagement.util.JsonUtil;
import com.example.employeemanagement.validator.RecordValidator;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final EntityManager entityManager;
    private final EmployeeService employeeService;
    private final RecordValidator recordValidator;

    @Override
    public RecordDto getById(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetRecordById", "RecordMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new NotFoundException(ErrorMessage.Record.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});
        }
        recordValidator.checkPermissionGet(id, userId);
        return (RecordDto) storedProcedureQuery.getSingleResult();
    }

    @Override
    public RecordDto create(int userId, RecordRequestDto recordRequestDto) {
        EmployeeDto employeeDto = employeeService.getById(recordRequestDto.getEmployeeProfileId(), userId);
        recordValidator.checkPermissionCreate(userId, employeeDto);
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CreateRecord", "RecordMapper")
                    .registerStoredProcedureParameter("recordJson", String.class, ParameterMode.IN)
                    .setParameter("recordJson", JsonUtil.toJson(recordRequestDto));
            return (RecordDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }
}
