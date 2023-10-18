package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.domain.dto.request.RecordRequestDto;
import com.example.employeemanagement.security.CurrentUser;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.RecordService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestApiV1
public class RecordController {
    private final RecordService recordService;

    @Tag(name = "record-controller")
    @Operation(summary = "API get record by id")
    @GetMapping(UrlConstant.Record.GET_BY_ID)
    public ResponseEntity<?> getById(@PathVariable int id,
                                     @Parameter(name = "principal", hidden = true)
                                     @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(recordService.getById(id, user.getId()));
    }

    @Tag(name = "record-controller")
    @Operation(summary = "API create record")
    @PostMapping(value = UrlConstant.Record.CREATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> create(@Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user,
                                    @Valid @RequestBody RecordRequestDto recordRequestDto) {
        return VsResponseUtil.success(recordService.create(user.getId(), recordRequestDto));
    }

}
