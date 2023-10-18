package com.example.employeemanagement.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.RegexConstant;
import com.example.employeemanagement.validator.annotation.ValidDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CertificateRequestDto {
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String name;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidDate
    private String issuedDate;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String issuedLocation;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String field;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String type;
    @Pattern(regexp = RegexConstant.STRING_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String description;
    @ValidDate
    private String effectiveDate;
}
