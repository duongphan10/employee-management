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
public class TerminationDto {
    private Integer id;
    private Integer employeeProfileId;
    private Integer managerId;
    private Integer leaderId;
    private LocalDate terminationDate;
    private String terminationReason;
    private String additionalRequestContent;
    private LocalDate rejectionDate;
    private String rejectionReason;
    private Integer statusId;
    private String statusName;

}
