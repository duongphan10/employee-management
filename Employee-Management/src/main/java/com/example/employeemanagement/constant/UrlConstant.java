package com.example.employeemanagement.constant;

public class UrlConstant {

    public static class Auth {
        private static final String PRE_FIX = "/auth";
        public static final String LOGIN = PRE_FIX + "/login";
        public static final String REGISTER = PRE_FIX + "/register";
        public static final String LOGOUT = PRE_FIX + "/logout";

        private Auth() {
        }
    }

    public static class User {
        private static final String PRE_FIX = "/user";
        public static final String GET_USER = PRE_FIX + "/{userId}";
        public static final String GET_CURRENT_USER = PRE_FIX + "/current";
        public static final String GET_All_LEADER = PRE_FIX + "/leader/all";

        private User() {
        }
    }

    public static class Certificate {
        private static final String PRE_FIX = "/certificate";
        public static final String GET_BY_ID = PRE_FIX + "/{id}";
        public static final String GET_ALL_BY_EMPLOYEE_ID = PRE_FIX + "/all/{employeeId}";
        public static final String CREATE = PRE_FIX + "/create/{employeeId}";
        public static final String UPDATE = PRE_FIX + "/{id}";
        public static final String DELETE = PRE_FIX + "/{id}";

        private Certificate() {
        }
    }

    public static class FamilyRelationship {
        private static final String PRE_FIX = "/family-relationship";
        public static final String GET_BY_ID = PRE_FIX + "/{id}";
        public static final String GET_ALL_BY_EMPLOYEE_ID = PRE_FIX + "/all/{employeeId}";
        public static final String CREATE = PRE_FIX + "/create/{employeeId}";
        public static final String UPDATE = PRE_FIX + "/{id}";
        public static final String DELETE = PRE_FIX + "/{id}";

        private FamilyRelationship() {
        }
    }

    public static class Employee {
        private static final String PRE_FIX = "/employee";
        public static final String GET_BY_ID = PRE_FIX + "/{id}";
        public static final String GET_ALL = PRE_FIX + "/all";
        public static final String CREATE = PRE_FIX + "/create";
        public static final String UPDATE = PRE_FIX + "/{id}";
        public static final String DELETE = PRE_FIX + "/{id}";
        private Employee() {
        }
    }

    public static class Registration {
        private static final String PRE_FIX = "/registration";
        public static final String GET_BY_ID = PRE_FIX + "/{id}";
        public static final String GET_ALL_BY_USER_ID = PRE_FIX + "/all";
        public static final String CREATE = PRE_FIX + "/create";
        public static final String UPDATE = PRE_FIX + "/{id}";
        public static final String DELETE = PRE_FIX + "/{id}";
        private Registration() {
        }
    }

    public static class Termination {
        private static final String PRE_FIX = "/termination";
        public static final String GET_BY_ID = PRE_FIX + "/{id}";
        public static final String GET_ALL_BY_USER_ID = PRE_FIX + "/all";
        public static final String CREATE = PRE_FIX + "/create";
        public static final String UPDATE = PRE_FIX + "/{id}";
        public static final String DELETE = PRE_FIX + "/{id}";
        private Termination() {
        }
    }

    public static class Record {
        private static final String PRE_FIX = "/record";
        public static final String GET_BY_ID = PRE_FIX + "/{id}";
        public static final String CREATE = PRE_FIX + "/create";
        private Record() {
        }
    }

    public static class SalaryIncrease {
        private static final String PRE_FIX = "/salary-increase";
        public static final String GET_BY_ID = PRE_FIX + "/{id}";
        public static final String GET_ALL_BY_USER_ID = PRE_FIX + "/all";
        public static final String CREATE = PRE_FIX + "/create";
        public static final String UPDATE = PRE_FIX + "/{id}";
        public static final String DELETE = PRE_FIX + "/{id}";
        private SalaryIncrease() {
        }
    }


    public static class Department {
        public static final String PRE_FIX = "/department";
        public static final String GET_ALL = PRE_FIX + "/all";
        private Department() {
        }
    }

    public static class Position {
        public static final String PRE_FIX = "/position";
        public static final String GET_ALL = PRE_FIX + "/all";
        private Position() {
        }
    }
}
