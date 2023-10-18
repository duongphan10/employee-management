package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.MessageConstant;
import com.example.employeemanagement.domain.dto.request.SalaryIncreaseCreateDto;
import com.example.employeemanagement.domain.dto.request.SalaryIncreaseUpdateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.RegistrationDto;
import com.example.employeemanagement.domain.dto.response.SalaryIncreaseDto;
import com.example.employeemanagement.exception.JsonException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.SalaryIncreaseService;
import com.example.employeemanagement.util.DateTimeUtil;
import com.example.employeemanagement.util.JsonUtil;
import com.example.employeemanagement.validator.SalaryIncreaseValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryIncreaseServiceImpl implements SalaryIncreaseService {
    private final EntityManager entityManager;
    private final EmployeeService employeeService;
    private final SalaryIncreaseValidator salaryIncreaseValidator;

    @Override
    public SalaryIncreaseDto getById(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetSalaryIncreaseById", "SalaryIncreaseMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new NotFoundException(ErrorMessage.SalaryIncrease.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});
        }
        salaryIncreaseValidator.checkPermissionGet(id, userId);
        return (SalaryIncreaseDto) storedProcedureQuery.getSingleResult();
    }

    @Override
    public List<SalaryIncreaseDto> getAllByUserId(int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllSalaryIncreaseByUserId", "SalaryIncreaseMapper")
                .registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
                .setParameter("userId", userId);
        List<SalaryIncreaseDto> salaryIncreaseDtos = storedProcedureQuery.getResultList();
        return salaryIncreaseDtos;
    }

    @Override
    public SalaryIncreaseDto create(int userId, SalaryIncreaseCreateDto salaryIncreaseCreateDto) {
        EmployeeDto employeeDto = employeeService.getById(salaryIncreaseCreateDto.getEmployeeProfileId(), userId);
        salaryIncreaseValidator.checkPermissionCreate(userId, employeeDto);
        salaryIncreaseCreateDto.setManagerId(userId);
        salaryIncreaseCreateDto.setDate(DateTimeUtil.toString(LocalDate.now()));
        salaryIncreaseCreateDto.setStatusId(DataConstant.Status.PENDING_INCREASE.getId());
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CreateSalaryIncrease", "SalaryIncreaseMapper")
                    .registerStoredProcedureParameter("salaryIncreaseJson", String.class, ParameterMode.IN)
                    .setParameter("salaryIncreaseJson", JsonUtil.toJson(salaryIncreaseCreateDto));
            return (SalaryIncreaseDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public SalaryIncreaseDto update(int id, int userId, SalaryIncreaseUpdateDto salaryIncreaseUpdateDto) {
        SalaryIncreaseDto salaryIncreaseDto = this.getById(id, userId);
        salaryIncreaseValidator.checkPermissionUpdate(userId, salaryIncreaseDto);
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_UpdateSalaryIncreaseById", "SalaryIncreaseMapper")
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("salaryIncreaseJson", String.class, ParameterMode.IN)
                    .setParameter("id", id)
                    .setParameter("salaryIncreaseJson", JsonUtil.toJson(salaryIncreaseUpdateDto));

            return (SalaryIncreaseDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public CommonResponseDto deleteById(int id, int userId) {
        SalaryIncreaseDto salaryIncreaseDto = this.getById(id, userId);
        salaryIncreaseValidator.checkPermissionDelete(userId, salaryIncreaseDto);

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_DeleteSalaryIncreaseById")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        return new CommonResponseDto(true, MessageConstant.DELETE_SALARY_INCREASE_SUCCESSFULLY);
    }

}
