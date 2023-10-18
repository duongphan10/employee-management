package com.example.employeemanagement.domain.mapper;


import com.example.employeemanagement.domain.dto.response.UserDetailsDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;

@MappedSuperclass
@SqlResultSetMapping(name = "UserDetailsMapper",
        classes = @ConstructorResult(
                targetClass = UserDetailsDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "password", type = String.class),
                        @ColumnResult(name = "role_name", type = String.class)
                }
        )
)
public class UserDetailsMapper {
}
