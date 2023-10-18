package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.service.PositionService;

@RequiredArgsConstructor
@RestApiV1
public class PositionController {

    private final PositionService positionService;

    @Tag(name = "position-controller")
    @Operation(summary = "API get all position")
    @GetMapping(UrlConstant.Position.GET_ALL)
    public ResponseEntity<?> getAll() {
        return VsResponseUtil.success(positionService.getAll());
    }
}
