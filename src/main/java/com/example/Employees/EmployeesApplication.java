package com.example.Employees;

import com.example.Employees.model.Employees;
import com.example.Employees.repository.EmployeesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(EmployeesRep employeesRep){
//		return args -> {
//			Employees kate = new Employees("Екатерина","Иванова","89999649227","Отдел Кадров");
//		};
//		employeesRep.save(kate);
//	}
}


