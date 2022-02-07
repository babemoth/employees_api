package com.example.Employees.controller;


import com.example.Employees.model.Employees;
import com.example.Employees.repository.EmployeesRep;
import com.example.Employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeesRep employeesRep;


    //get all employees
    public Employees findById(Long id){
        return employeesRep.findById(id).orElse(null);
    }

    //save a new employee
    public Employees saveEmployees(Employees employees){
        return employeesRep.save(employees);
    }


    //
    @GetMapping(value = "/employees")
    public List<Employees> getEmployees(){
        return employeesRep.findAll();
    }



    //delete an employee
    @GetMapping("/delete_employees")
    public void deleteById(Long id){
        employeesRep.deleteById(id);
    }


    //Create a new Note
    @PostMapping("/employees")
    public Employees createNote(@Valid @RequestBody Employees employees) {
        return employeesRep.save(employees);


//    @GetMapping("/employees")
//    public String findAll(Model model){
//        List<Employees> employees = employeesService.findAll();
//        model.addAttribute("employees",employees);
//        return "employees-list";
//    }
//
//    @GetMapping
//    public String createEmployeesForm(Employees employees){
//        return "create-employees";
//    }
//
//    @PostMapping
//    public String createEmployees(Employees employees){
//        employeesService.saveEmployees(employees);
//        return "redirect/employees";
//    }
//        public void deleteById(Long id){
//        employeesRep.deleteById(id);
//    }
}
