package com.example.employeemanagement.controller;

import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.domain.dto.request.RegistrationCreateDto;
import com.example.employeemanagement.domain.dto.request.RegistrationUpdateDto;
import com.example.employeemanagement.domain.dto.request.SalaryIncreaseCreateDto;
import com.example.employeemanagement.domain.dto.request.SalaryIncreaseUpdateDto;
import com.example.employeemanagement.security.CurrentUser;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.RegistrationService;
import com.example.employeemanagement.service.SalaryIncreaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestApiV1
public class SalaryIncreaseController {
    private final SalaryIncreaseService salaryIncreaseService;

    @Tag(name = "salary increase-controller")
    @Operation(summary = "API get salary increase by id")
    @GetMapping(UrlConstant.SalaryIncrease.GET_BY_ID)
    public ResponseEntity<?> getById(@PathVariable int id,
                                     @Parameter(name = "principal", hidden = true)
                                     @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(salaryIncreaseService.getById(id, user.getId()));
    }

    @Tag(name = "salary increase-controller")
    @Operation(summary = "API get all salary increase by user id")
    @GetMapping(UrlConstant.SalaryIncrease.GET_ALL_BY_USER_ID)
    public ResponseEntity<?> getAllByUserId(@Parameter(name = "principal", hidden = true)
                                            @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(salaryIncreaseService.getAllByUserId(user.getId()));
    }


    @Tag(name = "salary increase-controller")
    @Operation(summary = "API create salary increase")
    @PostMapping(value = UrlConstant.SalaryIncrease.CREATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> create(@Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user,
                                    @Valid @RequestBody SalaryIncreaseCreateDto salaryIncreaseCreateDto) {
        return VsResponseUtil.success(salaryIncreaseService.create(user.getId(), salaryIncreaseCreateDto));
    }

    @Tag(name = "salary increase-controller")
    @Operation(summary = "API update salary increase by id")
    @PatchMapping(UrlConstant.SalaryIncrease.UPDATE)
    @PreAuthorize("hasRole('ROLE_LEADER')")
    public ResponseEntity<?> updateById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user,
                                        @Valid @RequestBody SalaryIncreaseUpdateDto salaryIncreaseUpdateDto) {
        return VsResponseUtil.success(salaryIncreaseService.update(id, user.getId(), salaryIncreaseUpdateDto));
    }

    @Tag(name = "salary increase-controller")
    @Operation(summary = "API delete salary increase by id")
    @DeleteMapping(UrlConstant.SalaryIncrease.DELETE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> deleteById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(salaryIncreaseService.deleteById(id, user.getId()));
    }
}
