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
    @Override
    public List<Employees> retrieveEmployees() {
        List<Employees> employees = new ArrayList<Employees>();
        employeesRep.findAll().forEach(employees1 -> employees.add((employees1)));
        return employees;
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
    public Optional<Employees> getEmployees(Long employeesId) {
        return employeesRep.findById(employeesId);
    }

    @Override
    public Employees saveEmployees(Employees employees) {
        return employeesRep.save(employees);
    }

    @Override
    public String deleteEmployees(Long employeesId){
        employeesRep.deleteById(employeesId);
        return null;
    }
}
