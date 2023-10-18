package com.example.employeemanagement.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.RegexConstant;
import com.example.employeemanagement.validator.annotation.ValidDate;
import com.example.employeemanagement.validator.annotation.ValidFileImage;
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
public class EmployeeRequestFileDto {
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.FULL_NAME_REGEX, message = ErrorMessage.INVALID_FULL_NAME)
    private String fullName;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.EMPLOYEE_CODE_REGEX, message = ErrorMessage.INVALID_EMPLOYEE_CODE)
    private String code;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Boolean gender;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidDate
    private String birthday;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String hometown;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.ETHNICITY_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String ethnicity;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String religion;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String nationality;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String address;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer team;
    @ValidFileImage
    private MultipartFile image;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidIdCardNumber
    private String idCardNumber;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidDate
    private String idCardIssuedDate;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Pattern(regexp = RegexConstant.COMMON_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String idCardIssuedLocation;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @ValidPhone
    private String phoneNumber;
    @NotBlank(message = ErrorMessage.NOT_BLANK_FIELD)
    @Email(message = ErrorMessage.INVALID_FORMAT_EMAIL)
    private String email;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer salary;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer salaryLevel;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer departmentId;
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private Integer positionId;

}
