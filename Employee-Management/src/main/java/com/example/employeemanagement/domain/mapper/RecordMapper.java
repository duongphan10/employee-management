package com.example.employeemanagement.domain.mapper;

import com.example.employeemanagement.domain.dto.response.RecordDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@MappedSuperclass
@SqlResultSetMapping(name = "RecordMapper",
        classes = @ConstructorResult(
                targetClass = RecordDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "employee_profile_id", type = Integer.class),
                        @ColumnResult(name = "decision_date", type = LocalDate.class),
                        @ColumnResult(name = "saved_number", type = String.class)
                }
        )
)
public class RecordMapper {
}
