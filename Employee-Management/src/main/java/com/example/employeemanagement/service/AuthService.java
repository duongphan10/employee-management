package com.example.employeemanagement.service;

import org.springframework.security.core.Authentication;
import com.example.employeemanagement.domain.dto.request.LoginRequestDto;
import com.example.employeemanagement.domain.dto.request.TokenRefreshRequestDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;
import com.example.employeemanagement.domain.dto.response.LoginResponseDto;
import com.example.employeemanagement.domain.dto.response.TokenRefreshResponseDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto request);
    TokenRefreshResponseDto refresh(TokenRefreshRequestDto request);
    CommonResponseDto logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication);

}
