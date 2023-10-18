package com.example.employeemanagement.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.MessageConstant;
import com.example.employeemanagement.domain.dto.request.RegistrationCreateDto;
import com.example.employeemanagement.domain.dto.request.RegistrationUpdateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.RegistrationDto;
import com.example.employeemanagement.exception.JsonException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.RegistrationService;
import com.example.employeemanagement.util.DateTimeUtil;
import com.example.employeemanagement.util.JsonUtil;
import com.example.employeemanagement.validator.RegistrationValidator;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final EntityManager entityManager;
    private final RegistrationValidator registrationValidator;
    private final EmployeeService employeeService;

    @Override
    public RegistrationDto getById(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetRegistrationById", "RegistrationMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new NotFoundException(ErrorMessage.Registration.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});
        }
        registrationValidator.checkPermissionGet(id, userId);
        return (RegistrationDto) storedProcedureQuery.getSingleResult();
    }

    @Override
    public List<RegistrationDto> getAllByUserId(int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllRegistrationByUserId", "RegistrationMapper")
                .registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
                .setParameter("userId", userId);
        List<RegistrationDto> registrationDtos = storedProcedureQuery.getResultList();
        return registrationDtos;
    }

    @Override
    public RegistrationDto create(int userId, RegistrationCreateDto registrationCreateDto) {
        EmployeeDto employeeDto = employeeService.getById(registrationCreateDto.getEmployeeProfileId(), userId);
        registrationValidator.checkPermissionCreate(userId, employeeDto);

        registrationCreateDto.setManagerId(userId);
        registrationCreateDto.setSubmissionDate(DateTimeUtil.toString(LocalDate.now()));
        registrationCreateDto.setStatusId(DataConstant.Status.PENDING_REG.getId());
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CreateRegistration", "RegistrationMapper")
                    .registerStoredProcedureParameter("registrationJson", String.class, ParameterMode.IN)
                    .setParameter("registrationJson", JsonUtil.toJson(registrationCreateDto));
            return (RegistrationDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public RegistrationDto update(int id, int userId, RegistrationUpdateDto registrationUpdateDto) {
        RegistrationDto registrationDto = this.getById(id, userId);
        registrationValidator.checkPermissionUpdate(userId, registrationDto, registrationUpdateDto);

        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_UpdateRegistrationById", "RegistrationMapper")
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("registrationJson", String.class, ParameterMode.IN)
                    .setParameter("id", id)
                    .setParameter("registrationJson", JsonUtil.toJson(registrationUpdateDto));

            return (RegistrationDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public CommonResponseDto deleteById(int id, int userId) {
        RegistrationDto registrationDto = this.getById(id, userId);
        registrationValidator.checkPermissionDelete(userId, registrationDto);

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_DeleteRegistrationById")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        return new CommonResponseDto(true, MessageConstant.DELETE_REGISTRATION_SUCCESSFULLY);
    }
}
