package com.example.employeemanagement.domain.mapper;


import com.example.employeemanagement.domain.dto.response.DepartmentDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;

@MappedSuperclass
@SqlResultSetMapping(name = "DepartmentMapper",
        classes = @ConstructorResult(
                targetClass = DepartmentDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "description", type = String.class)
                }
        )
)
public class DepartmentMapper {
}
