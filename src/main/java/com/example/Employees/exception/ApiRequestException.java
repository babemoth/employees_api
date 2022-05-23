package com.example.Employees.exception;

public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String msg){
        super(msg);
    }
}
