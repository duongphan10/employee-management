package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.domain.dto.request.RegistrationCreateDto;
import com.example.employeemanagement.domain.dto.request.RegistrationUpdateDto;
import com.example.employeemanagement.security.CurrentUser;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.RegistrationService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestApiV1
public class RegistrationController {
    private final RegistrationService registrationService;

    @Tag(name = "registration-controller")
    @Operation(summary = "API get registration by id")
    @GetMapping(UrlConstant.Registration.GET_BY_ID)
    public ResponseEntity<?> getById(@PathVariable int id,
                                     @Parameter(name = "principal", hidden = true)
                                     @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(registrationService.getById(id, user.getId()));
    }

    @Tag(name = "registration-controller")
    @Operation(summary = "API get all registration by user id")
    @GetMapping(UrlConstant.Registration.GET_ALL_BY_USER_ID)
    public ResponseEntity<?> getAllByUserId(@Parameter(name = "principal", hidden = true)
                                            @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(registrationService.getAllByUserId(user.getId()));
    }


    @Tag(name = "registration-controller")
    @Operation(summary = "API create registration")
    @PostMapping(value = UrlConstant.Registration.CREATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> create(@Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user,
                                    @Valid @RequestBody RegistrationCreateDto registrationCreateDto) {
        return VsResponseUtil.success(registrationService.create(user.getId(), registrationCreateDto));
    }

    @Tag(name = "registration-controller")
    @Operation(summary = "API update registration by id")
    @PatchMapping(UrlConstant.Registration.UPDATE)
    public ResponseEntity<?> updateById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user,
                                        @Valid @RequestBody RegistrationUpdateDto registrationRequestDto) {
        return VsResponseUtil.success(registrationService.update(id, user.getId(), registrationRequestDto));
    }

    @Tag(name = "registration-controller")
    @Operation(summary = "API delete registration by id")
    @DeleteMapping(UrlConstant.Registration.DELETE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> deleteById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(registrationService.deleteById(id, user.getId()));
    }
}
