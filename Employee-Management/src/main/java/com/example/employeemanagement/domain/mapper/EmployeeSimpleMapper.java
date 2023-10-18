package com.example.employeemanagement.domain.mapper;

import com.example.employeemanagement.domain.dto.response.EmployeeDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@MappedSuperclass
@SqlResultSetMapping(name = "EmployeeSimpleMapper",
        classes = @ConstructorResult(
                targetClass = EmployeeDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "full_name", type = String.class),
                        @ColumnResult(name = "code", type = String.class),
                        @ColumnResult(name = "gender", type = Boolean.class),
                        @ColumnResult(name = "birthday", type = LocalDate.class),
                        @ColumnResult(name = "hometown", type = String.class),
                        @ColumnResult(name = "id_card_number", type = String.class),
                        @ColumnResult(name = "phone_number", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "department_id", type = Integer.class),
                        @ColumnResult(name = "position_id", type = Integer.class),
                        @ColumnResult(name = "status_id", type = Integer.class),
                        @ColumnResult(name = "status_name", type = String.class)
                }
        )
)
public class EmployeeSimpleMapper {
}
