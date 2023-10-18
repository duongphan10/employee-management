package com.example.employeemanagement.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.RegexConstant;
import com.example.employeemanagement.validator.annotation.ValidDate;
import com.example.employeemanagement.validator.annotation.ValidIdCardNumber;
import com.example.employeemanagement.validator.annotation.ValidPhone;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FamilyRelationshipRequestDto {
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.FULL_NAME_REGEX, message = ErrorMessage.INVALID_FULL_NAME)
    private String fullName;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Boolean gender;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidDate
    private String birthday;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidIdCardNumber
    private String idCardNumber;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.RELATIONSHIP_REGEX, message = ErrorMessage.INVALID_FULL_NAME)
    private String relationship;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String address;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String occupation;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    @ValidPhone
    private String phoneNumber;
    @Email(message = ErrorMessage.INVALID_FORMAT_EMAIL)
    private String email;
}
