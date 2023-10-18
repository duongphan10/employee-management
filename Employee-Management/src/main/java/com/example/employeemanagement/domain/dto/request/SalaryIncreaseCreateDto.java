package com.example.employeemanagement.domain.dto.request;

import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.validator.annotation.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaryIncreaseCreateDto {
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer employeeProfileId;
    private Integer managerId;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer leaderId;
    @ValidDate
    private String date;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    private String reason;
    private String description;
    private Integer statusId;
}
