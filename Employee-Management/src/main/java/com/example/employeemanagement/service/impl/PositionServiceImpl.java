package com.example.employeemanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.domain.dto.response.PositionDto;
import com.example.employeemanagement.service.PositionService;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final EntityManager entityManager;

    @Override
    public List<PositionDto> getAll() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_GetAllPosition", "PositionMapper");
        return (List<PositionDto>) storedProcedureQuery.getResultList();
    }
}
