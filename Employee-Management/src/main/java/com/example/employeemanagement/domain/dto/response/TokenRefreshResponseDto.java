package com.example.employeemanagement.domain.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.employeemanagement.constant.CommonConstant;

@NoArgsConstructor
@Setter
@Getter
public class TokenRefreshResponseDto {

    private String tokenType = CommonConstant.BEARER_TOKEN;

    private String accessToken;

    private String refreshToken;

    public TokenRefreshResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}
