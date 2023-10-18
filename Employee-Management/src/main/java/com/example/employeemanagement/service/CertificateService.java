package com.example.employeemanagement.service;

import com.example.employeemanagement.domain.dto.request.CertificateRequestDto;
import com.example.employeemanagement.domain.dto.response.CertificateDto;
import com.example.employeemanagement.domain.dto.response.CommonResponseDto;

import java.util.List;

public interface CertificateService {
    List<CertificateDto> getAllByEmployeeId(int employeeId, int userId);

    CertificateDto getById(int id, int userId);

    List<CertificateDto> create(int userId, int employeeId, List<CertificateRequestDto> dto);

    CertificateDto updateById(int id, CertificateRequestDto certificateRequestDto, int userId);

    CommonResponseDto deleteById(int id, int userId);

}
