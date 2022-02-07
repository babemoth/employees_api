package com.example.Employees.service;

import com.example.Employees.model.Employees;
import com.example.Employees.repository.EmployeesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRep employeesRep;

    public EmployeesService(EmployeesRep employeesRep) {
        this.employeesRep = employeesRep;
    }

//    public Employees findById(Long id){
//        return employeesRep.findById(id).orElse(null);
//    }
//
//    public List<Employees> findAll(){
//        return employeesRep.findAll();
//    }
//
//    public Employees saveEmployees(Employees employees){
//        return employeesRep.save(employees);
//    }
//
//    public void deleteById(Long id){
//        employeesRep.deleteById(id);
//    }

}
