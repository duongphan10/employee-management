package com.example.employeemanagement.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.employeemanagement.constant.DataConstant;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.domain.dto.request.TerminationUpdateDto;
import com.example.employeemanagement.domain.dto.response.EmployeeDto;
import com.example.employeemanagement.domain.dto.response.TerminationDto;
import com.example.employeemanagement.exception.ForbiddenException;
import com.example.employeemanagement.exception.InvalidException;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Component
@RequiredArgsConstructor
public class TerminationValidator {

    private final EntityManager entityManager;

    public void checkPermissionGet(int id, int userId) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_CheckPermissionGetTermination")
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
            throw new ForbiddenException(ErrorMessage.Termination.FORBIDDEN_CREATE);
        if (employeeDto.getStatusId() != DataConstant.Status.APPROVED.getId() &&
                employeeDto.getStatusId() != DataConstant.Status.REJECT_TERM.getId())
            throw new ForbiddenException(ErrorMessage.Termination.FORBIDDEN_CREATE_BY_STATUS);
    }

    public void checkPermissionUpdate(int userId, TerminationDto terminationDto, TerminationUpdateDto terminationUpdateDto) {
        if (userId != terminationDto.getManagerId() && userId != terminationDto.getLeaderId()) {
            throw new ForbiddenException(ErrorMessage.Termination.FORBIDDEN_UPDATE);
        }
        if ((terminationDto.getManagerId() == userId && terminationDto.getStatusId() != DataConstant.Status.ADDITIONAL_REQUEST_TERM.getId())
                || (terminationDto.getLeaderId() == userId && terminationDto.getStatusId() != DataConstant.Status.PENDING_TERM.getId())) {
            throw new ForbiddenException(ErrorMessage.Termination.FORBIDDEN_UPDATE_BY_STATUS);
        }
        if ((terminationDto.getManagerId() == userId && terminationUpdateDto.getStatusId() != DataConstant.Status.PENDING_TERM.getId())
                || (terminationDto.getLeaderId() == userId && terminationUpdateDto.getStatusId() == DataConstant.Status.PENDING_TERM.getId())) {
            throw new InvalidException(ErrorMessage.Termination.INVALID_STATUS_UPDATE);
        }

    }

    public void checkPermissionDelete(int userId, TerminationDto terminationDto) {
        if (terminationDto.getManagerId() != userId)
            throw new ForbiddenException(ErrorMessage.Termination.FORBIDDEN_DELETE);
        if (terminationDto.getStatusId() != DataConstant.Status.REJECT_TERM.getId())
            throw new ForbiddenException(ErrorMessage.Termination.FORBIDDEN_DELETE_BY_STATUS);
    }

}
