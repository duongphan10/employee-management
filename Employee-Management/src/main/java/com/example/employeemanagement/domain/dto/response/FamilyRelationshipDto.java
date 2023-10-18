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
public class FamilyRelationshipDto {
    private Integer id;
    private String fullName;
    private Boolean gender;
    private LocalDate birthday;
    private String idCardNumber;
    private String relationship;
    private String address;
    private String occupation;
    private String phoneNumber;
    private String email;
    private Integer employeeProfileId;

}
