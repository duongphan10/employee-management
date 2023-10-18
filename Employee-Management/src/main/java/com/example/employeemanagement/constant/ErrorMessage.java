package com.example.employeemanagement.constant;

public class ErrorMessage {

    public static final String ERR_EXCEPTION_GENERAL = "exception.general";
    public static final String UNAUTHORIZED = "exception.unauthorized";
    public static final String FORBIDDEN = "exception.forbidden";
    public static final String FORBIDDEN_UPDATE_DELETE = "exception.forbidden.update-delete";
    public static final String ERR_EXCEPTION_MAX_UPLOAD_FILE_SIZE = "exception.max.upload.file.size";
    public static final String ERR_EXCEPTION_MULTIPART = "exception.multipart";
    public static final String ERR_EXCEPTION_JSON_PROCESSING = "exception.json.processing";

    //error validation dto
    public static final String INVALID_SOME_THING_FIELD = "invalid.general";
    public static final String INVALID_FORMAT_SOME_THING_FIELD = "invalid.general.format";
    public static final String INVALID_SOME_THING_FIELD_IS_REQUIRED = "invalid.general.required";
    public static final String NOT_BLANK_FIELD = "invalid.general.not-blank";
    public static final String INVALID_FORMAT_PASSWORD = "invalid.password-format";
    public static final String INVALID_FORMAT_EMAIL = "invalid.email-format";
    public static final String INVALID_FORMAT_PHONE = "invalid.phone-format";
    public static final String INVALID_DATE = "invalid.date-format";
    public static final String INVALID_DATE_FEATURE = "invalid.date-future";
    public static final String INVALID_DATETIME = "invalid.datetime-format";

    public static final String INVALID_FULL_NAME = "invalid.full.name.format";
    public static final String INVALID_EMPLOYEE_CODE = "invalid.employee.code.format";

    public static final String INVALID_REGISTRATION_STATUS_UPDATE = "invalid.registration.status.update";
    public static final String INVALID_TERMINATION_STATUS_UPDATE = "invalid.termination.status.update";
    public static final String INVALID_SALARY_INCREASE_STATUS_UPDATE = "invalid.salary.increase.status.update";



    public static class Auth {
        public static final String ERR_INCORRECT_USERNAME = "exception.auth.incorrect.username";
        public static final String ERR_INCORRECT_PASSWORD = "exception.auth.incorrect.password";
        public static final String ERR_ACCOUNT_NOT_ENABLED = "exception.auth.account.not.enabled";
        public static final String ERR_ACCOUNT_LOCKED = "exception.auth.account.locked";
        public static final String INVALID_REFRESH_TOKEN = "exception.auth.invalid.refresh.token";
        public static final String EXPIRED_REFRESH_TOKEN = "exception.auth.expired.refresh.token";
    }

    public static class User {
        public static final String ERR_NOT_FOUND_USERNAME = "exception.user.not.found.username";
        public static final String ERR_NOT_FOUND_ID = "exception.user.not.found.id";
    }

    public static class Role {
        public static final String ERR_NOT_FOUND_NAME = "exception.role.not.found.name";
        public static final String ERR_NOT_FOUND_ID = "exception.role.not.found.id";
    }

    public static class Certificate {
        public static final String ERR_NOT_FOUND_ID = "exception.certificate.not.found.id";
        public static final String FORBIDDEN_CREATE = "exception.certificate.forbidden.create";
        public static final String FORBIDDEN_CREATE_BY_STATUS = "exception.certificate.forbidden.create.by.status";
        public static final String FORBIDDEN_UPDATE = "exception.certificate.forbidden.update";
        public static final String FORBIDDEN_UPDATE_BY_STATUS = "exception.certificate.forbidden.update.by.status";
        public static final String FORBIDDEN_DELETE = "exception.certificate.forbidden.delete";
        public static final String FORBIDDEN_DELETE_BY_STATUS = "exception.certificate.forbidden.delete.by.status";
    }

    public static class FamilyRelationship {
        public static final String ERR_NOT_FOUND_ID = "exception.family.relationship.not.found.id";
        public static final String FORBIDDEN_CREATE = "exception.family.relationship.forbidden.create";
        public static final String FORBIDDEN_CREATE_BY_STATUS = "exception.family.relationship.forbidden.create.by.status";
        public static final String FORBIDDEN_UPDATE = "exception.family.relationship.forbidden.update";
        public static final String FORBIDDEN_UPDATE_BY_STATUS = "exception.family.relationship.forbidden.update.by.status";
        public static final String FORBIDDEN_DELETE = "exception.family.relationship.forbidden.delete";
        public static final String FORBIDDEN_DELETE_BY_STATUS = "exception.family.relationship.forbidden.delete.by.status";
    }

    public static class Employee {
        public static final String ERR_NOT_FOUND_ID = "exception.employee.not.found.id";
        public static final String FORBIDDEN_UPDATE = "exception.employee.forbidden.update";
        public static final String FORBIDDEN_UPDATE_BY_STATUS = "exception.employee.forbidden.update.by.status";
        public static final String FORBIDDEN_DELETE = "exception.employee.forbidden.delete";
        public static final String FORBIDDEN_DELETE_BY_STATUS = "exception.employee.forbidden.delete.by.status";
    }

    public static class Registration {
        public static final String ERR_NOT_FOUND_ID = "exception.registration.not.found.id";
        public static final String FORBIDDEN_CREATE = "exception.registration.forbidden.create";
        public static final String FORBIDDEN_CREATE_BY_STATUS = "exception.registration.forbidden.create.by.status";
        public static final String FORBIDDEN_UPDATE = "exception.registration.forbidden.update";
        public static final String FORBIDDEN_UPDATE_BY_STATUS = "exception.registration.forbidden.update.by.status";
        public static final String INVALID_STATUS_UPDATE = "exception.registration.invalid.status.update";
        public static final String FORBIDDEN_DELETE = "exception.registration.forbidden.delete";
        public static final String FORBIDDEN_DELETE_BY_STATUS = "exception.registration.forbidden.delete.by.status";
    }

    public static class Termination {
        public static final String ERR_NOT_FOUND_ID = "exception.termination.not.found.id";
        public static final String FORBIDDEN_CREATE = "exception.termination.forbidden.create";
        public static final String FORBIDDEN_CREATE_BY_STATUS = "exception.termination.forbidden.create.by.status";
        public static final String FORBIDDEN_UPDATE = "exception.termination.forbidden.update";
        public static final String FORBIDDEN_UPDATE_BY_STATUS = "exception.termination.forbidden.update.by.status";
        public static final String INVALID_STATUS_UPDATE = "exception.termination.invalid.status.update";
        public static final String FORBIDDEN_DELETE = "exception.termination.forbidden.delete";
        public static final String FORBIDDEN_DELETE_BY_STATUS = "exception.termination.forbidden.delete.by.status";
    }

    public static class Record {
        public static final String ERR_NOT_FOUND_ID = "exception.record.not.found.id";
        public static final String FORBIDDEN_CREATE = "exception.record.forbidden.create";
        public static final String FORBIDDEN_CREATE_BY_STATUS = "exception.record.forbidden.create.by.status";
    }

    public static class SalaryIncrease {
        public static final String ERR_NOT_FOUND_ID = "exception.salary.increase.not.found.id";
        public static final String FORBIDDEN_CREATE = "exception.salary.increase.forbidden.create";
        public static final String FORBIDDEN_CREATE_BY_STATUS = "exception.salary.increase.forbidden.create.by.status";
        public static final String FORBIDDEN_UPDATE = "exception.salary.increase.forbidden.update";
        public static final String FORBIDDEN_UPDATE_BY_STATUS = "exception.salary.increase.forbidden.update.by.status";
        public static final String FORBIDDEN_DELETE = "exception.salary.increase.forbidden.delete";
        public static final String FORBIDDEN_DELETE_BY_STATUS = "exception.salary.increase.forbidden.delete.by.status";
    }
}
