package com.example.employeemanagement.domain.mapper;

import com.example.employeemanagement.domain.dto.response.CertificateDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@MappedSuperclass
@SqlResultSetMapping(name = "CertificateMapper",
        classes = @ConstructorResult(
                targetClass = CertificateDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "issued_date", type = LocalDate.class),
                        @ColumnResult(name = "issued_location", type = String.class),
                        @ColumnResult(name = "field", type = String.class),
                        @ColumnResult(name = "type", type = String.class),
                        @ColumnResult(name = "description", type = String.class),
                        @ColumnResult(name = "effective_date", type = LocalDate.class),
                        @ColumnResult(name = "employee_profile_id", type = Integer.class)
                }
        )
)
public class CertificateMapper {
}
