package com.example.Employees.service;

import com.example.Employees.model.Employees;
import com.example.Employees.repository.EmployeesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRep employeesRep; //inject repository dependency

    public void setEmployeesRep(EmployeesRep employeesRep) {
        this.employeesRep = employeesRep;
    }

//    public void run(String... args) throws Exception{
//        for(Employees empl :this.employeesRep.findAll()){
//            System.out.println(empl.toString());
//        }
//    }
    @Override
    public List<Employees> retrieveEmployees() {
        List<Employees> employees = new ArrayList<Employees>();
        employeesRep.findAll().forEach(employees1 -> employees.add((employees1)));
        return employees;

        //return employeesRep.findAll();
    }

    public Optional<Employees> employeeById(Long id){
        return employeesRep.findById(id);
    }



    public Employees updateEmployees(Long id, Employees employees) {
        Optional<Employees> employeesById = employeesRep.findById(id);

        if(employeesById.isPresent()) {
            Employees updatedEmployees = employeesById.get();

            updatedEmployees.setId(employees.getId());
            updatedEmployees.setName(employees.getName());
            updatedEmployees.setLastName(employees.getLastName());
            updatedEmployees.setPhoneNumber(employees.getPhoneNumber());
            updatedEmployees.setDepartmentName(employees.getDepartmentName());

            return employeesRep.save(updatedEmployees);
        }

        return null;
    }

    @Override
    public Employees getEmployees(Long employeesId) {
        Optional<Employees> optEmp = employeesRep.findById(employeesId);
        if (optEmp.isPresent()) return optEmp.get();
        return optEmp.get();
    }

    @Override
    public Employees saveEmployees(Employees employees) {
        return employeesRep.save(employees);
    }

    @Override
    public String deleteEmployees(Long employeesId) {
        employeesRep.deleteById(employeesId);
        return null;
    }

//    @Override
//    public void updateEmployees(Employees employees) {
//        employeesRep.save(employees);
//    }
}
