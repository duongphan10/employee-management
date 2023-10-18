package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.service.UserService;

@RequiredArgsConstructor
@RestApiV1
public class UserController {

    private final UserService userService;

    @Tag(name = "user-controller")
    @Operation(summary = "API get user")
    @GetMapping(UrlConstant.User.GET_USER)
    public ResponseEntity<?> getUserById(@PathVariable int userId) {
        return VsResponseUtil.success(userService.getById(userId));
    }

    @Tag(name = "user-controller")
    @Operation(summary = "API get all leader")
    @GetMapping(UrlConstant.User.GET_All_LEADER)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> getAllLeader() {
        return VsResponseUtil.success(userService.getAllLeader());
    }

}
