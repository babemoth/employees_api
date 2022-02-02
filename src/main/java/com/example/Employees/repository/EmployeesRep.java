package com.example.Employees.repository;

import com.example.Employees.db.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRep extends CrudRepository<Employees, Long> {
}
