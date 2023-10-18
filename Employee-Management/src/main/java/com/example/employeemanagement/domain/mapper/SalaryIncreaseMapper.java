package com.example.employeemanagement.domain.mapper;

import com.example.employeemanagement.domain.dto.response.SalaryIncreaseDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@MappedSuperclass
@SqlResultSetMapping(name = "SalaryIncreaseMapper",
        classes = @ConstructorResult(
                targetClass = SalaryIncreaseDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "employee_profile_id", type = Integer.class),
                        @ColumnResult(name = "manager_id", type = Integer.class),
                        @ColumnResult(name = "leader_id", type = Integer.class),
                        @ColumnResult(name = "date", type = LocalDate.class),
                        @ColumnResult(name = "increase_number", type = Integer.class),
                        @ColumnResult(name = "reason", type = String.class),
                        @ColumnResult(name = "description", type = String.class),
                        @ColumnResult(name = "status_id", type = Integer.class)
                }
        )
)
public class SalaryIncreaseMapper {
}
