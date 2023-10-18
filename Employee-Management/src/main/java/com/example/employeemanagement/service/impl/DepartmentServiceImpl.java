package com.example.employeemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.domain.dto.response.DepartmentDto;
import com.example.employeemanagement.service.DepartmentService;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final EntityManager entityManager;

    @Override
    public List<DepartmentDto> getAll() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllDepartment", "DepartmentMapper");
        return (List<DepartmentDto>) storedProcedureQuery.getResultList();
    }
}
