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
import com.example.employeemanagement.domain.dto.request.TerminationCreateDto;
import com.example.employeemanagement.domain.dto.request.TerminationUpdateDto;
import com.example.employeemanagement.security.CurrentUser;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.TerminationService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestApiV1
public class TerminationController {
    private final TerminationService terminationService;

    @Tag(name = "termination-controller")
    @Operation(summary = "API get termination by id")
    @GetMapping(UrlConstant.Termination.GET_BY_ID)
    public ResponseEntity<?> getById(@PathVariable int id,
                                     @Parameter(name = "principal", hidden = true)
                                     @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(terminationService.getById(id, user.getId()));
    }

    @Tag(name = "termination-controller")
    @Operation(summary = "API get all termination by user id")
    @GetMapping(UrlConstant.Termination.GET_ALL_BY_USER_ID)
    public ResponseEntity<?> getAllByUserId(@Parameter(name = "principal", hidden = true)
                                            @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(terminationService.getALlByUserId(user.getId()));
    }


    @Tag(name = "termination-controller")
    @Operation(summary = "API create termination")
    @PostMapping(value = UrlConstant.Termination.CREATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> create(@Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user,
                                    @Valid @RequestBody TerminationCreateDto terminationCreateDto) {
        return VsResponseUtil.success(terminationService.create(user.getId(), terminationCreateDto));
    }

    @Tag(name = "termination-controller")
    @Operation(summary = "API update termination by id")
    @PatchMapping(UrlConstant.Termination.UPDATE)
    public ResponseEntity<?> updateById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user,
                                        @Valid @RequestBody TerminationUpdateDto terminationRequestDto) {
        return VsResponseUtil.success(terminationService.update(id, user.getId(), terminationRequestDto));
    }

    @Tag(name = "termination-controller")
    @Operation(summary = "API delete termination by id")
    @DeleteMapping(UrlConstant.Termination.DELETE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> deleteById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(terminationService.deleteById(id, user.getId()));
    }
}
