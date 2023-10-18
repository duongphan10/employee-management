package com.example.employeemanagement.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.MessageConstant;
import com.example.employeemanagement.domain.dto.request.CertificateRequestDto;
import com.example.employeemanagement.domain.dto.response.CertificateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.exception.JsonException;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.CertificateService;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.util.JsonUtil;
import com.example.employeemanagement.validator.CertificateValidator;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {
    private final EntityManager entityManager;
    private final EmployeeService employeeService;
    private final CertificateValidator certificateValidator;

    @Override
    public List<CertificateDto> getAllByEmployeeId(int employeeId, int userId) {
        employeeService.getById(employeeId, userId);

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllCertificateByEmployeeId", "CertificateMapper")
                .registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN)
                .setParameter("employeeId", employeeId);
        return (List<CertificateDto>) storedProcedureQuery.getResultList();
    }

    @Override
    public CertificateDto getById(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetCertificateById", "CertificateMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new NotFoundException(ErrorMessage.Certificate.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});
        }
        certificateValidator.checkPermissionGet(id, userId);

        return (CertificateDto) storedProcedureQuery.getSingleResult();

    }

    @Override
    public List<CertificateDto> create(int userId, int employeeId, List<CertificateRequestDto> certificateRequestDtos) {
        EmployeeDto employeeDto = employeeService.getById(employeeId, userId);
        certificateValidator.checkPermissionCreate(userId, employeeDto);
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CreateCertificate", "CertificateMapper")
                    .registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("certificateJson", String.class, ParameterMode.IN)
                    .setParameter("employeeId", employeeId)
                    .setParameter("certificateJson", JsonUtil.toJson(certificateRequestDtos));
            return (List<CertificateDto>) storedProcedureQuery.getResultList();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }

    }

    @Override
    public CertificateDto updateById(int id, CertificateRequestDto certificateRequestDto, int userId) {
        CertificateDto certificateDto = this.getById(id, userId);
        certificateValidator.checkPermissionUpdate(certificateDto.getEmployeeProfileId(), userId);

        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_UpdateCertificateById", "CertificateMapper")
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("certificateJson", String.class, ParameterMode.IN)
                    .setParameter("id", id)
                    .setParameter("certificateJson", JsonUtil.toJson(certificateRequestDto));
            return (CertificateDto) storedProcedureQuery.getSingleResult();
        } catch (JsonProcessingException e) {
            throw new JsonException(ErrorMessage.ERR_EXCEPTION_JSON_PROCESSING);
        }
    }

    @Override
    public CommonResponseDto deleteById(int id, int userId) {
        CertificateDto certificateDto = this.getById(id, userId);
        certificateValidator.checkPermissionDelete(certificateDto.getEmployeeProfileId(), userId);

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_DeleteCertificateById")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        return new CommonResponseDto(true, MessageConstant.DELETE_CERTIFICATE_SUCCESSFULLY);
    }
}
