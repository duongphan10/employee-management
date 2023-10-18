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
import com.example.employeemanagement.domain.dto.request.CertificateRequestDto;
import com.example.employeemanagement.security.CurrentUser;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.CertificateService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestApiV1
public class CertificateController {
    private final CertificateService certificateService;

    @Tag(name = "certificate-controller")
    @Operation(summary = "API get certificate by id")
    @GetMapping(UrlConstant.Certificate.GET_BY_ID)
    public ResponseEntity<?> getById(@PathVariable int id,
                                     @Parameter(name = "principal", hidden = true)
                                     @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(certificateService.getById(id, user.getId()));
    }

    @Tag(name = "certificate-controller")
    @Operation(summary = "API get all certificate by employee id")
    @GetMapping(UrlConstant.Certificate.GET_ALL_BY_EMPLOYEE_ID)
    public ResponseEntity<?> getAllByEmployeeId(@PathVariable int employeeId,
                                                @Parameter(name = "principal", hidden = true)
                                                @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(certificateService.getAllByEmployeeId(employeeId, user.getId()));
    }

    @Tag(name = "certificate-controller")
    @Operation(summary = "API create certificate")
    @PostMapping(UrlConstant.Certificate.CREATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> create(@PathVariable int employeeId,
                                    @Valid @RequestBody List<CertificateRequestDto> certificateRequestDtos,
                                    @Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(certificateService.create(user.getId(), employeeId, certificateRequestDtos));
    }

    @Tag(name = "certificate-controller")
    @Operation(summary = "API update certificate by id")
    @PatchMapping(UrlConstant.Certificate.UPDATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> updateById(@PathVariable int id,
                                        @Valid @RequestBody CertificateRequestDto certificateRequestDto,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(certificateService.updateById(id, certificateRequestDto, user.getId()));
    }

    @Tag(name = "certificate-controller")
    @Operation(summary = "API delete certificate by id")
    @DeleteMapping(UrlConstant.Certificate.DELETE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> deleteById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(certificateService.deleteById(id, user.getId()));
    }
}
