package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.service.DepartmentService;

@RequiredArgsConstructor
@RestApiV1
public class DepartmentController {

    private final DepartmentService departmentService;

    @Tag(name = "department-controller")
    @Operation(summary = "API get all department")
    @GetMapping(UrlConstant.Department.GET_ALL)
    public ResponseEntity<?> getAll() {
        return VsResponseUtil.success(departmentService.getAll());
    }
}
