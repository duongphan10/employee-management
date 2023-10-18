package com.example.employeemanagement.domain.mapper;

import com.example.employeemanagement.domain.dto.response.EmployeeDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@MappedSuperclass
@SqlResultSetMapping(name = "EmployeeMapper",
        classes = @ConstructorResult(
                targetClass = EmployeeDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "full_name", type = String.class),
                        @ColumnResult(name = "code", type = String.class),
                        @ColumnResult(name = "gender", type = Boolean.class),
                        @ColumnResult(name = "birthday", type = LocalDate.class),
                        @ColumnResult(name = "hometown", type = String.class),
                        @ColumnResult(name = "ethnicity", type = String.class),
                        @ColumnResult(name = "religion", type = String.class),
                        @ColumnResult(name = "nationality", type = String.class),
                        @ColumnResult(name = "address", type = String.class),
                        @ColumnResult(name = "team", type = Integer.class),
                        @ColumnResult(name = "image", type = String.class),
                        @ColumnResult(name = "id_card_number", type = String.class),
                        @ColumnResult(name = "id_card_issued_date", type = LocalDate.class),
                        @ColumnResult(name = "id_card_issued_location", type = String.class),
                        @ColumnResult(name = "phone_number", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "salary", type = Integer.class),
                        @ColumnResult(name = "salary_level", type = Integer.class),
                        @ColumnResult(name = "created_by", type = Integer.class),
                        @ColumnResult(name = "department_id", type = Integer.class),
                        @ColumnResult(name = "position_id", type = Integer.class),
                        @ColumnResult(name = "status_id", type = Integer.class),
                        @ColumnResult(name = "status_name", type = String.class)
                }
        )
)
public class EmployeeMapper {
}
