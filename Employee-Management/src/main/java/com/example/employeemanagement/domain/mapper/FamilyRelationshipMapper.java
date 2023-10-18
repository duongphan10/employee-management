package com.example.employeemanagement.domain.mapper;

import com.example.employeemanagement.domain.dto.response.FamilyRelationshipDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@MappedSuperclass
@SqlResultSetMapping(name = "FamilyRelationshipMapper",
        classes = @ConstructorResult(
                targetClass = FamilyRelationshipDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "full_name", type = String.class),
                        @ColumnResult(name = "gender", type = Boolean.class),
                        @ColumnResult(name = "birthday", type = LocalDate.class),
                        @ColumnResult(name = "id_card_number", type = String.class),
                        @ColumnResult(name = "relationship", type = String.class),
                        @ColumnResult(name = "address", type = String.class),
                        @ColumnResult(name = "occupation", type = String.class),
                        @ColumnResult(name = "phone_number", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "employee_profile_id", type = Integer.class)
                }
        )
)
public class FamilyRelationshipMapper {
}
