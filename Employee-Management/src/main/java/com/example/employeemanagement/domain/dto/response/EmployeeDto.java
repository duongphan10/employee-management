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
public class EmployeeDto {
    private Integer id;
    private String fullName;
    private String code;
    private Boolean gender;
    private LocalDate birthday;
    private String hometown;
    private String ethnicity;
    private String religion;
    private String nationality;
    private String address;
    private Integer team;
    private String image;
    private String idCardNumber;
    private LocalDate idCardIssuedDate;
    private String idCardIssuedLocation;
    private String phoneNumber;
    private String email;
    private Integer salary;
    private Integer salaryLevel;
    private Integer createdBy;
    private Integer departmentId;
    private Integer positionId;
    private Integer statusId;
    private String statusName;

    public EmployeeDto(Integer id, String fullName, String code, Boolean gender, LocalDate birthday, String hometown, String idCardNumber, String phoneNumber, String email, Integer departmentId, Integer positionId, Integer statusId, String statusName) {
        this.id = id;
        this.fullName = fullName;
        this.code = code;
        this.gender = gender;
        this.birthday = birthday;
        this.hometown = hometown;
        this.idCardNumber = idCardNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.statusId = statusId;
        this.statusName = statusName;
    }
}
