package com.example.employeemanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class JsonException extends RuntimeException {

    private String message;

    private HttpStatus status;

    private String[] params;

    public JsonException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.message = message;
    }

    public JsonException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public JsonException(String message, String[] params) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.message = message;
        this.params = params;
    }

    public JsonException(HttpStatus status, String message, String[] params) {
        super(message);
        this.status = status;
        this.message = message;
        this.params = params;
    }

}