package com.example.employeemanagement.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.employeemanagement.constant.ErrorMessage;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeProfileRequestDto {
    @NotNull(message = ErrorMessage.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private EmployeeRequestDto employeeRequestDto;
    private List<CertificateRequestDto> certificateRequestDtos;
    private List<FamilyRelationshipRequestDto> familyRelationshipRequestDtos;
}
