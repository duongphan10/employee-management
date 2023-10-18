package com.example.employeemanagement.domain.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import com.example.employeemanagement.constant.CommonConstant;

import java.util.Collection;

@NoArgsConstructor
@Setter
@Getter
public class LoginResponseDto {

    private String tokenType = CommonConstant.BEARER_TOKEN;

    private String accessToken;

    private String refreshToken;

    private Integer id;

    private Collection<? extends GrantedAuthority> authorities;

    public LoginResponseDto(String accessToken, String refreshToken, Integer id, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.authorities = authorities;
    }

}
