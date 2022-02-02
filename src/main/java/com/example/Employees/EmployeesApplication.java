package com.example.Employees;

import com.example.Employees.db.Employees;
import com.example.Employees.repository.EmployeesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class EmployeesApplication {


	@Autowired
	private EmployeesRep employeesRep;

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}


	@RequestMapping("create-employee")
	public Employees createEmployee(){

		return employeesRep.save(new Employees());
	}
}
