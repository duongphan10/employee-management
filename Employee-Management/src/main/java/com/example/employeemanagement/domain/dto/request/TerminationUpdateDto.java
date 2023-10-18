package com.example.employeemanagement.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.employeemanagement.constant.ErrorMessage;
import com.example.employeemanagement.constant.RegexConstant;
import com.example.employeemanagement.validator.annotation.ValidDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TerminationUpdateDto {
    @ValidDate
    private String terminationDate;
    @Pattern(regexp = RegexConstant.STRING_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String terminationReason;
    @Pattern(regexp = RegexConstant.STRING_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String additionalRequestContent;
    @ValidDate
    private String rejectionDate;
    @Pattern(regexp = RegexConstant.STRING_REGEX, message = ErrorMessage.INVALID_FORMAT_SOME_THING_FIELD)
    private String rejectionReason;
    @Min(value = 6, message = ErrorMessage.INVALID_TERMINATION_STATUS_UPDATE)
    @Max(value = 9, message = ErrorMessage.INVALID_TERMINATION_STATUS_UPDATE)
    private Integer statusId;
}
