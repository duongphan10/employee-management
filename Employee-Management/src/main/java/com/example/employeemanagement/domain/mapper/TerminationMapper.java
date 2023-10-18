package com.example.employeemanagement.domain.mapper;

import com.example.employeemanagement.domain.dto.response.TerminationDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@MappedSuperclass
@SqlResultSetMapping(name = "TerminationMapper",
        classes = @ConstructorResult(
                targetClass = TerminationDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "employee_profile_id", type = Integer.class),
                        @ColumnResult(name = "manager_id", type = Integer.class),
                        @ColumnResult(name = "leader_id", type = Integer.class),
                        @ColumnResult(name = "termination_date", type = LocalDate.class),
                        @ColumnResult(name = "termination_reason", type = String.class),
                        @ColumnResult(name = "additional_request_content", type = String.class),
                        @ColumnResult(name = "rejection_date", type = LocalDate.class),
                        @ColumnResult(name = "rejection_reason", type = String.class),
                        @ColumnResult(name = "status_id", type = Integer.class),
                        @ColumnResult(name = "status_name", type = String.class)
                }
        )
)
public class TerminationMapper {
}
