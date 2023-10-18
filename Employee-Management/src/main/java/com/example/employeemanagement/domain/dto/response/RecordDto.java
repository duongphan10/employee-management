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
public class RecordDto {
    private Integer id;
    private Integer employeeProfileId;
    private LocalDate decisionDate;
    private String savedNumber;
}
