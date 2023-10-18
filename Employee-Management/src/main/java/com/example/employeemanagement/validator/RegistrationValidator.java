package com.example.employeemanagement.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.domain.dto.request.RegistrationUpdateDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.RegistrationDto;
import com.example.employeemanagement.exception.ForbiddenException;
import com.example.employeemanagement.exception.InvalidException;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Component
@RequiredArgsConstructor
public class RegistrationValidator {

    private final EntityManager entityManager;

    public void checkPermissionGet(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CheckPermissionGetRegistration")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id)
                .setParameter("userId", userId);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new ForbiddenException(ErrorMessage.FORBIDDEN);
        }
    }

    public void checkPermissionCreate(int userId, EmployeeDto employeeDto) {
        if (employeeDto.getCreatedBy() != userId)
            throw new ForbiddenException(ErrorMessage.Registration.FORBIDDEN_CREATE);
        if (employeeDto.getStatusId() != DataConstant.Status.NEW.getId() &&
                employeeDto.getStatusId() != DataConstant.Status.REJECT_REG.getId())
            throw new ForbiddenException(ErrorMessage.Registration.FORBIDDEN_CREATE_BY_STATUS);
    }

    public void checkPermissionUpdate(int userId, RegistrationDto registrationDto, RegistrationUpdateDto registrationUpdateDto) {
        if (userId != registrationDto.getManagerId() && userId != registrationDto.getLeaderId()) {
            throw new ForbiddenException(ErrorMessage.Registration.FORBIDDEN_UPDATE);
        }
        if ((registrationDto.getManagerId() == userId && registrationDto.getStatusId() != DataConstant.Status.ADDITIONAL_REQUEST_REG.getId())
                || (registrationDto.getLeaderId() == userId && registrationDto.getStatusId() != DataConstant.Status.PENDING_REG.getId())) {
            throw new ForbiddenException(ErrorMessage.Registration.FORBIDDEN_UPDATE_BY_STATUS);
        }
        if ((registrationDto.getManagerId() == userId && registrationUpdateDto.getStatusId() != DataConstant.Status.PENDING_REG.getId())
                || (registrationDto.getLeaderId() == userId && registrationUpdateDto.getStatusId() == DataConstant.Status.PENDING_REG.getId())) {
            throw new InvalidException(ErrorMessage.Registration.INVALID_STATUS_UPDATE);
        }

    }

    public void checkPermissionDelete(int userId, RegistrationDto registrationDto) {
        if (registrationDto.getManagerId() != userId)
            throw new ForbiddenException(ErrorMessage.Registration.FORBIDDEN_DELETE);
        if (registrationDto.getStatusId() != DataConstant.Status.REJECT_REG.getId())
            throw new ForbiddenException(ErrorMessage.Registration.FORBIDDEN_DELETE_BY_STATUS);
    }

}
