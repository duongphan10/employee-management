package com.example.employeemanagement.validator;

import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.RegistrationDto;
import com.example.employeemanagement.domain.dto.response.SalaryIncreaseDto;
import com.example.employeemanagement.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Component
@RequiredArgsConstructor
public class SalaryIncreaseValidator {

    private final EntityManager entityManager;

    public void checkPermissionGet(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CheckPermissionGetSalaryIncrease")
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
            throw new ForbiddenException(ErrorMessage.SalaryIncrease.FORBIDDEN_CREATE);
        if (employeeDto.getStatusId() != DataConstant.Status.APPROVED.getId() && employeeDto.getStatusId() != DataConstant.Status.REJECT_TERM.getId())
            throw new ForbiddenException(ErrorMessage.SalaryIncrease.FORBIDDEN_CREATE_BY_STATUS);
    }

    public void checkPermissionUpdate(int userId, SalaryIncreaseDto salaryIncreaseDto) {
        if (salaryIncreaseDto.getLeaderId() != userId)
            throw new ForbiddenException(ErrorMessage.SalaryIncrease.FORBIDDEN_UPDATE);
        if (salaryIncreaseDto.getStatusId() != DataConstant.Status.PENDING_INCREASE.getId())
            throw new ForbiddenException(ErrorMessage.SalaryIncrease.FORBIDDEN_UPDATE_BY_STATUS);
    }

    public void checkPermissionDelete(int userId, SalaryIncreaseDto salaryIncreaseDto) {
        if (salaryIncreaseDto.getManagerId() != userId)
            throw new ForbiddenException(ErrorMessage.SalaryIncrease.FORBIDDEN_DELETE);
        if (salaryIncreaseDto.getStatusId() == DataConstant.Status.PENDING_INCREASE.getId())
            throw new ForbiddenException(ErrorMessage.SalaryIncrease.FORBIDDEN_DELETE_BY_STATUS);
    }

}
