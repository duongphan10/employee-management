package com.example.employeemanagement.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.MessageConstant;
import com.example.employeemanagement.domain.dto.request.EmployeeProfileRequestDto;
import com.example.employeemanagement.domain.dto.request.EmployeeRequestDto;
import com.example.employeemanagement.domain.dto.request.EmployeeRequestFileDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.exception.JsonException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.util.DateTimeUtil;
import com.example.employeemanagement.util.FileUtil;
import com.example.employeemanagement.util.JsonUtil;
import com.example.employeemanagement.validator.EmployeeValidator;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EntityManager entityManager;
    private final EmployeeValidator employeeValidator;

    @Override
    public List<EmployeeDto> getAll(int userId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_GetAllEmployeeByUserId", "EmployeeSimpleMapper")
                .registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
                .setParameter("userId", userId);
        return (List<EmployeeDto>) query.getResultList();
    }

    @Override
    public EmployeeDto getById(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetEmployeeById", "EmployeeMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0)
            throw new NotFoundException(ErrorMessage.Employee.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});

        employeeValidator.checkPermissionGet(id, userId);

        return (EmployeeDto) storedProcedureQuery.getSingleResult();
    }

    @Override
    public EmployeeDto create(MultipartFile file, EmployeeProfileRequestDto employeeProfileRequestDto, int userId) {
        String imageSave = FileUtil.saveFile(DateTimeUtil.toStringPathFile(LocalDateTime.now()), file);
        employeeProfileRequestDto.getEmployeeRequestDto().setImage(imageSave);

        employeeProfileRequestDto.getEmployeeRequestDto().setStatusId(DataConstant.Status.NEW.getId());
        employeeProfileRequestDto.getEmployeeRequestDto().setCreatedBy(userId);

        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CreateEmployee", "EmployeeMapper")
                    .registerStoredProcedureParameter("employeeProfileJson", String.class, ParameterMode.IN)
                    .setParameter("employeeProfileJson", JsonUtil.toJson(employeeProfileRequestDto));
            return (EmployeeDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public EmployeeDto updateById(int id, EmployeeRequestFileDto employeeRequestFileDto, int userId) {
        EmployeeDto employeeDto = this.getById(id, userId);
        employeeValidator.checkPermissionUpdate(userId, employeeDto);

        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto(employeeRequestFileDto);
        if (employeeRequestFileDto.getImage() != null) {
            if (employeeDto.getImage() != null) {
                FileUtil.deleteFile(employeeDto.getImage());
            }
            String newImage = FileUtil.saveFile(DateTimeUtil.toStringPathFile(LocalDateTime.now()), employeeRequestFileDto.getImage());
            employeeRequestDto.setImage(newImage);
        }

        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_UpdateEmployeeById", "EmployeeMapper")
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("employeeJson", String.class, ParameterMode.IN)
                    .setParameter("id", id)
                    .setParameter("employeeJson", JsonUtil.toJson(employeeRequestDto));
            return (EmployeeDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public CommonResponseDto deleteById(int id, int userId) {
        EmployeeDto employeeDto = this.getById(id, userId);
        employeeValidator.checkPermissionDelete(userId, employeeDto);
        if (employeeDto.getImage() != null) {
            FileUtil.deleteFile(employeeDto.getImage());
        }
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_DeleteEmployeeById")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        return new CommonResponseDto(true, MessageConstant.DELETE_EMPLOYEE_SUCCESSFULLY);
    }
}
