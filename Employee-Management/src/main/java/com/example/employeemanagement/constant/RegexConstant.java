package com.example.employeemanagement.constant;

public class RegexConstant {
    public static final String COMMON_REGEX = "^[\\p{L}\\p{N} .,-]{1,255}$";
    public static final String STRING_REGEX = "^.{1,255}$";

    public static final String FULL_NAME_REGEX = "^[A-Za-z]+( [\\p{L}]+){1,49}$";
    public static final String EMPLOYEE_CODE_REGEX = "^[A-Za-z0-9]{1,50}$";
    public static final String ETHNICITY_REGEX = "^[\\p{L} ]{1,50}$";
    public static final String RELATIONSHIP_REGEX = "^[\\p{L} ]{1,50}$";



}
