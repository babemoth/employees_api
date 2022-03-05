package com.example.Employees.service;

import com.example.Employees.model.Employees;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface EmployeesService {

    public List<Employees> retrieveEmployees();

    Optional<Employees> getEmployees(Long employeesId);

    Employees saveEmployees(Employees employees);

    public String deleteEmployees(Long employeeId);

    public Employees updateEmployees(Long id, Employees employees);
}
