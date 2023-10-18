package com.example.employeemanagement.domain.dto.request;

import com.example.employeemanagement.constant.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaryIncreaseUpdateDto {
    @Min(value = 12, message = ErrorMessage.INVALID_SALARY_INCREASE_STATUS_UPDATE)
    @Max(value = 13, message = ErrorMessage.INVALID_SALARY_INCREASE_STATUS_UPDATE)
    private Integer statusId;
}
