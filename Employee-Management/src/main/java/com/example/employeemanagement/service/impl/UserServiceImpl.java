package com.example.employeemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.domain.dto.response.UserDto;
import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final EntityManager entityManager;

    @Override
    public UserDto getById(int id) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetUserById", "UserMapper")
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT)
                .setParameter("id", id);
        storedProcedureQuery.execute();
        int result = (int) storedProcedureQuery.getOutputParameterValue("result");
        if (result == 0) {
            throw new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_ID, new String[]{Integer.toString(id)});
        }
        return (UserDto) storedProcedureQuery.getSingleResult();
    }

    @Override
    public List<UserDto> getAllLeader() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllUserLeader", "UserSimpleMapper");
        storedProcedureQuery.execute();
        return (List<UserDto>) storedProcedureQuery.getResultList();
    }

}
