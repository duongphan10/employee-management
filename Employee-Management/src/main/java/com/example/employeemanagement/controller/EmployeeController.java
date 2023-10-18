package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.domain.dto.request.EmployeeProfileRequestDto;
import com.example.employeemanagement.domain.dto.request.EmployeeRequestFileDto;
import com.example.employeemanagement.security.CurrentUser;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.EmployeeService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestApiV1
public class EmployeeController {
    private final EmployeeService employeeService;

    @Tag(name = "employee-controller")
    @Operation(summary = "API get employee by id")
    @GetMapping(UrlConstant.Employee.GET_BY_ID)
    public ResponseEntity<?> getById(@PathVariable int id,
                                     @Parameter(name = "principal", hidden = true)
                                     @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(employeeService.getById(id, user.getId()));
    }

    @Tag(name = "employee-controller")
    @Operation(summary = "API get all employee")
    @GetMapping(UrlConstant.Employee.GET_ALL)
    public ResponseEntity<?> getAll(@Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(employeeService.getAll(user.getId()));
    }

    @Tag(name = "employee-controller")
    @Operation(summary = "API create employee")
    @PostMapping(value = UrlConstant.Employee.CREATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> create(@RequestPart("image") MultipartFile file,
                                    @Valid @RequestPart("employeeProfile") EmployeeProfileRequestDto employeeProfileRequestDto,
                                    @Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(employeeService.create(file, employeeProfileRequestDto, user.getId()));
    }

    @Tag(name = "employee-controller")
    @Operation(summary = "API update employee by id")
    @PatchMapping(UrlConstant.Employee.UPDATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> updateById(@PathVariable int id,
                                        @Valid @ModelAttribute EmployeeRequestFileDto employeeRequestFileDto,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(employeeService.updateById(id, employeeRequestFileDto, user.getId()));
    }

    @Tag(name = "employee-controller")
    @Operation(summary = "API delete employee by id")
    @DeleteMapping(UrlConstant.Employee.DELETE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> deleteById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(employeeService.deleteById(id, user.getId()));
    }
}
