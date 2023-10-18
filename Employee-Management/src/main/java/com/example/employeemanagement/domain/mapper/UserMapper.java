package com.example.employeemanagement.domain.mapper;


import com.example.employeemanagement.domain.dto.response.UserDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;

@MappedSuperclass
@SqlResultSetMapping(name = "UserMapper",
        classes = @ConstructorResult(
                targetClass = UserDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "full_name", type = String.class),
                        @ColumnResult(name = "gender", type = Boolean.class),
                        @ColumnResult(name = "phone_number", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "avatar", type = String.class),
                        @ColumnResult(name = "department_id", type = Integer.class),
                        @ColumnResult(name = "position_id", type = Integer.class),
                        @ColumnResult(name = "role_id", type = Integer.class)
                }
        )
)
public class UserMapper {
}
