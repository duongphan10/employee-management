package com.example.employeemanagement.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaryIncreaseDto {
    private Integer id;
    private Integer employeeProfileId;
    private Integer managerId;
    private Integer leaderId;
    private LocalDate date;
    private Integer increaseNumber;
    private String reason;
    private String description;
    private Integer statusId;
}
