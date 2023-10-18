package com.example.employeemanagement.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String username;
    private String fullName;
    private Boolean gender;
    private String phoneNumber;
    private String email;
    private String avatar;
    private Integer departmentId;
    private Integer positionId;
    private Integer roleId;

    public UserDto(Integer id, String fullName, Boolean gender, Integer departmentId, Integer positionId, Integer roleId) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.roleId = roleId;
    }
}

