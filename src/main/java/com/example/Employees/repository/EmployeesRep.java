package com.example.Employees.repository;

import com.example.Employees.model.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeesRep extends CrudRepository<Employees, Long> {
    Optional<Employees> findById(Long id);
}
