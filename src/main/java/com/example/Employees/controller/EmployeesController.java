package com.example.Employees.controller;

import com.example.Employees.exception.ApiRequestException;
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

    //get all employees
    @GetMapping("/api/employees")
    public List<Employees> getEmployees() {
        List<Employees> employees = employeesService.retrieveEmployees();
        return employees;
    }

    //get an employee by id
    @GetMapping("/api/employees/{employeesId}")
    public Employees getEmployeesById(@PathVariable(name="employeesId")Long employeesId){
        Optional<Employees> emp = employeesService.getEmployees(employeesId);
        if (emp.isPresent()) {
            return emp.get();
        }
        throw new ApiRequestException("No employee with such id.");
    }

    //create a new employee
    @GetMapping("/api/create_employee")
    public Employees createEmployee(@RequestParam String name, @RequestParam String last_name, @RequestParam String phone_number, @RequestParam String department_name) {
        Employees emp = new Employees();
            emp.setName(name);
            emp.setLastName(last_name);
            emp.setPhoneNumber(phone_number);
            emp.setDepartmentName(department_name);
            employeesService.saveEmployees(emp);
            System.out.println("Employee Saved Successfully ");
            return emp;
        }
    //edit an employee
    @GetMapping("/api/edit_employee")
    public Employees editEmployee(@RequestParam Long id, @RequestParam String name, @RequestParam String last_name, @RequestParam String phone_number, @RequestParam String department_name){
        Optional<Employees> empl = employeesService.getEmployees(id);
        if (empl.isPresent()) {
            Employees emp = empl.get();
            emp.setName(name);
            emp.setLastName(last_name);
            emp.setPhoneNumber(phone_number);
            emp.setDepartmentName(department_name);
            employeesService.saveEmployees(emp);
            return emp;
        }
        throw new ApiRequestException("No employee with such id.");
    }

    //update employee's department
    @GetMapping("/api/update_employee_department")
    public Employees updateEmployees(@RequestParam Long id, @RequestParam String department_name) {
        Optional<Employees> empl = employeesService.getEmployees(id);
        if(empl.isPresent()) {
            Employees emp = empl.get();
            emp.setDepartmentName(department_name);
            System.out.println(emp.toString());
            employeesService.saveEmployees(emp);
            return emp;
        }
        throw new ApiRequestException("No employee with such id");
    }

    //delete an employee
    @GetMapping("/api/delete_employee/{id}")
    public void deleteEmployee(@PathVariable(name="id")Long id){
        Optional<Employees> emp = employeesService.getEmployees(id);
        if (emp.isPresent()) {
            employeesService.deleteEmployees(id);
            System.out.println("Employee Deleted Successfully");
        }
        throw new ApiRequestException("No employee with such id");
    }
}
