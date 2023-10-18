package com.example.employeemanagement.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.exception.ForbiddenException;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Component
@RequiredArgsConstructor
public class EmployeeValidator {
    private final EntityManager entityManager;

    public void checkPermissionGet(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CheckPermissionGetEmployee")
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

    public void checkPermissionUpdate(int userId, EmployeeDto employeeDto) {
        if (employeeDto.getCreatedBy() != userId)
            throw new ForbiddenException(ErrorMessage.Employee.FORBIDDEN_UPDATE);
        if (employeeDto.getStatusId() != DataConstant.Status.NEW.getId())
            throw new ForbiddenException(ErrorMessage.Employee.FORBIDDEN_UPDATE_BY_STATUS);
    }

    public void checkPermissionDelete(int userId, EmployeeDto employeeDto) {
        if (employeeDto.getCreatedBy() != userId)
            throw new ForbiddenException(ErrorMessage.Employee.FORBIDDEN_DELETE);
        if (employeeDto.getStatusId() != DataConstant.Status.NEW.getId())
            throw new ForbiddenException(ErrorMessage.Employee.FORBIDDEN_DELETE_BY_STATUS);
    }

}
