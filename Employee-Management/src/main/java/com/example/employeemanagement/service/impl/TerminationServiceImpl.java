package com.example.employeemanagement.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.MessageConstant;
import com.example.employeemanagement.domain.dto.request.TerminationCreateDto;
import com.example.employeemanagement.domain.dto.request.TerminationUpdateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.TerminationDto;
import com.example.employeemanagement.exception.JsonException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.TerminationService;
import com.example.employeemanagement.util.DateTimeUtil;
import com.example.employeemanagement.util.JsonUtil;
import com.example.employeemanagement.validator.TerminationValidator;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerminationServiceImpl implements TerminationService {

    private final EntityManager entityManager;
    private final TerminationValidator terminationValidator;
    private final EmployeeService employeeService;

    @Override
    public TerminationDto getById(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetTerminationById", "TerminationMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new NotFoundException(ErrorMessage.Termination.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});
        }
        terminationValidator.checkPermissionGet(id, userId);
        return (TerminationDto) storedProcedureQuery.getSingleResult();
    }

    @Override
    public List<TerminationDto> getALlByUserId(int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllTerminationByUserId", "TerminationMapper")
                .registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
                .setParameter("userId", userId);
        List<TerminationDto> terminationDtos = storedProcedureQuery.getResultList();
        return terminationDtos;
    }

    @Override
    public TerminationDto create(int userId, TerminationCreateDto terminationCreateDto) {
        EmployeeDto employeeDto = employeeService.getById(terminationCreateDto.getEmployeeProfileId(), userId);
        terminationValidator.checkPermissionCreate(userId, employeeDto);

        terminationCreateDto.setManagerId(userId);
        terminationCreateDto.setTerminationDate(DateTimeUtil.toString(LocalDate.now()));
        terminationCreateDto.setStatusId(DataConstant.Status.PENDING_TERM.getId());
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CreateTermination", "TerminationMapper")
                    .registerStoredProcedureParameter("terminationJson", String.class, ParameterMode.IN)
                    .setParameter("terminationJson", JsonUtil.toJson(terminationCreateDto));
            return (TerminationDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public TerminationDto update(int id, int userId, TerminationUpdateDto terminationUpdateDto) {
        TerminationDto terminationDto = this.getById(id, userId);
        terminationValidator.checkPermissionUpdate(userId, terminationDto, terminationUpdateDto);

        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_UpdateTerminationById", "TerminationMapper")
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("terminationJson", String.class, ParameterMode.IN)
                    .setParameter("id", id)
                    .setParameter("terminationJson", JsonUtil.toJson(terminationUpdateDto));

            return (TerminationDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public CommonResponseDto deleteById(int id, int userId) {
        TerminationDto terminationDto = this.getById(id, userId);
        terminationValidator.checkPermissionDelete(userId, terminationDto);

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_DeleteTerminationById")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        return new CommonResponseDto(true, MessageConstant.DELETE_TERMINATION_SUCCESSFULLY);
    }
}
