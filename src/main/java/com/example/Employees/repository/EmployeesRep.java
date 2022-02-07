package com.example.Employees.repository;

import com.example.Employees.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRep extends JpaRepository<Employees, Long> {
}
