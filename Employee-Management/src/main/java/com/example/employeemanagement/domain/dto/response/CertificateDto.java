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
public class CertificateDto {
    private Integer id;
    private String name;
    private LocalDate issuedDate;
    private String issuedLocation;
    private String field;
    private String type;
    private String description;
    private LocalDate effectiveDate;
    private Integer employeeProfileId;

}
