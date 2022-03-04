package com.example.Employees.exception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(Long employeesId) {
        super("Employee is not found with id");
    }

    public EmployeeNotFoundException() {
        super("ff");
    }
//    private int id;

//    public EmployeeNotFoundException(int id){
//        super("Employee is not found with id");
//    }
}