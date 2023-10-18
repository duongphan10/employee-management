package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.domain.dto.request.LoginRequestDto;
import com.example.employeemanagement.service.AuthService;
import com.example.employeemanagement.service.CustomUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@RestApiV1
public class AuthController {

    private final AuthService authService;
    private final CustomUserDetailsService customUserDetailsService;

    @Operation(summary = "API Login")
    @PostMapping(UrlConstant.Auth.LOGIN)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto request) {
        return VsResponseUtil.success(authService.login(request));
    }

    @Operation(summary = "API Logout")
    @GetMapping(UrlConstant.Auth.LOGOUT)
    public ResponseEntity<?> logout(HttpServletRequest request,
                                    HttpServletResponse response, Authentication authentication) {
        return VsResponseUtil.success(authService.logout(request, response, authentication));
    }

    @GetMapping("auth/test/{id}")
    public ResponseEntity<?> load(@PathVariable Integer id) {
        return VsResponseUtil.success(customUserDetailsService.loadUserById(id));
    }
}
