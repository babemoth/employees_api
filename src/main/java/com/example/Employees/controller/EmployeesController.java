package com.example.Employees.controller;


import com.example.Employees.model.Employees;
import com.example.Employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    public void setEmployeeService(EmployeesService employeeService) {
        this.employeesService = employeeService;
    }

    @GetMapping("/api/employees")
    public List<Employees> getEmployees() {
        List<Employees> employees = employeesService.retrieveEmployees();
        return employees;
    }

    @GetMapping("/api/employees/{employeesId}")
    public Employees getEmployees(@PathVariable(name="employeesId")Long employeesId) {
        Employees emp = employeesService.getEmployees(employeesId);
        System.out.println();
        return employeesService.getEmployees(employeesId);
    }

    @GetMapping("/api/create_employee")
    public Employees createEmployee(@RequestParam String name, @RequestParam String last_name, @RequestParam String phone_number, @RequestParam String department_name){
        Employees emp = new Employees();
//        emp.setId(id);
        emp.setName(name);
        emp.setLastName(last_name);
        emp.setPhoneNumber(phone_number);
        emp.setDepartmentName(department_name);
        employeesService.saveEmployees(emp);
        System.out.println("Employee Saved Successfully ");
        return emp;
    }

    @GetMapping("/api/edit_employee")
    public Employees editEmployee(@RequestParam Long id, @RequestParam String name, @RequestParam String last_name, @RequestParam String phone_number, @RequestParam String department_name){
        Optional<Employees> employees = employeesService.employeeById(id);
        Employees emp = employees.get();
        emp.setName(name);
        emp.setLastName(last_name);
        emp.setPhoneNumber(phone_number);
        emp.setDepartmentName(department_name);
        employeesService.saveEmployees(emp);
        System.out.println("Edit Saved Successfully ");
        return emp;
    }

    @GetMapping("/api/update_employee_department")
    public Employees updateEmployees(@RequestParam Long id, @RequestParam String department_name) {
        Optional<Employees> employees = employeesService.employeeById(id);
        Employees emp = employees.get();
        emp.setDepartmentName(department_name);
        System.out.println(emp.toString());
        employeesService.saveEmployees(emp);
        return emp;
    }
    @GetMapping("/api/delete_employee/{id}")
    public void deleteEmployee(@PathVariable(name="id")Long id){
        employeesService.deleteEmployees(id);
        System.out.println("Employee Deleted Successfully");
    }
//
}
