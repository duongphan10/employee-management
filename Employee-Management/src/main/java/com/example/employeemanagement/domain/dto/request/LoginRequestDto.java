package com.example.employeemanagement.domain.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.employeemanagement.constant.ErrorMessage;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginRequestDto {

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    private String username;

    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    private String password;

}
