package com.example.Employees.exception;

import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

public class ApiException {
    private final String msg;
    private final Throwable cause;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(String msg, Throwable cause, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.msg = msg;
        this.cause = cause;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public Throwable getCause() {
        return cause;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
