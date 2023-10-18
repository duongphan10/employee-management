package com.example.employeemanagement.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.validator.annotation.ValidDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecordRequestDto {
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer employeeProfileId;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidDate
    private String decisionDate;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    private String savedNumber;
}
