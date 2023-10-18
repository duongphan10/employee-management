package com.example.employeemanagement.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.RegexConstant;
import com.example.employeemanagement.validator.annotation.ValidDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TerminationCreateDto {
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer employeeProfileId;
    private Integer managerId;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer leaderId;
    @ValidDate
    private String terminationDate;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.STRING_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String terminationReason;
    private Integer statusId;
}
