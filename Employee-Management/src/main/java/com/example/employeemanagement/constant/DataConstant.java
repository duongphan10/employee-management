package com.example.employeemanagement.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class DataConstant {
    @Getter
    @AllArgsConstructor
    public enum Role {
        MANAGER(1, "ROLE_MANAGER"),
        LEADER(2, "ROLE_LEADER");
        private final int id;
        private final String name;
    }

    @Getter
    public static final class Gender {
        public static final int MALE = 1;
        public static final int FEMALE = 0;
    }

    @Getter
    @AllArgsConstructor
    public enum Status {
        NEW(1, "NEW"),
        PENDING_REG(2, "PENDING_REGISTRATION"),
        ADDITIONAL_REQUEST_REG(3, "ADDITIONAL_REQUEST_REGISTRATION"),
        APPROVED(4, "APPROVED"),
        REJECT_REG(5, "REJECT_REGISTRATION"),
        PENDING_TERM(6, "PENDING_TERMINATION"),
        ADDITIONAL_REQUEST_TERM(7, "ADDITIONAL_REQUEST_TERMINATION"),
        END(8, "END"),
        REJECT_TERM(9, "REJECT_TERMINATION"),
        SAVED(10, "SAVED"),
        PENDING_INCREASE(11, "PENDING_INCREASE_SALARY"),
        APPROVED_INCREASE(12, "APPROVED_INCREASE_SALARY"),
        REJECT_INCREASE(13, "REJECT_INCREASE_SALARY");

        private final int id;
        private final String name;

        public static Integer getIdByName(String name) {
            for (Status status : Status.values()) {
                if (status.name.equals(name) ) {
                    return status.id;
                }
            }
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum Position {
        FA(1, "Financial Analyst"),
        AS(2, "Advertising Specialist"),
        HRS(3, "Human Resources Specialist"),
        SE(4, "Software Engineer"),
        TE(5, "Technician"),
        SR(6, "Sales Representative"),
        PM(7, "Project Manager");
        private final int id;
        private final String name;
    }

    @Getter
    @AllArgsConstructor
    public enum Department {
        FIN(1, "Finance"),
        HR(2, "Human Resources"),
        MS(3, "Marketing and Sales"),
        PMO(4, "Project Management Office"),
        IT(4, "Information Technology");
        private final int id;
        private final String name;
    }

}