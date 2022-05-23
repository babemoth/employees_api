package com.example.Employees;

import com.example.Employees.model.Employees;
import com.example.Employees.repository.EmployeesRep;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.*;
;

//@DataJpaTest
@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeesController.class)
@SpringBootTest
public class EmployeesServiceTest {

    @Autowired
    EmployeesRep employeesRep;

    @Test
    @Order(1)
    public void testCreate () {
        Employees emp = new Employees();
        emp.setId(1L);
        emp.setName("Игорь");
        emp.setLastName("Фантазеров");
        emp.setPhoneNumber("89999472837");
        emp.setDepartmentName("Отдел Образования");
        employeesRep.save(emp);
        Employees emp1 = new Employees();
        emp1.setId(2L);
        emp1.setName("Kate");
        emp1.setLastName("Povisheva");
        emp1.setPhoneNumber("89999472837");
        emp1.setDepartmentName("Отдел Образования");
        employeesRep.save(emp1);
        Employees emp2 = new Employees();
        emp2.setId(3L);
        emp2.setName("Kate");
        emp2.setLastName("Povisheva");
        emp2.setPhoneNumber("89999472837");
        emp2.setDepartmentName("Отдел Образования");
        employeesRep.save(emp2);
        assertNotNull(employeesRep.findById(1L).get());
        assertNotNull(employeesRep.findById(2L).get());
        assertNotNull(employeesRep.findById(3L).get());
    }


    @Test
    @Order(2)
    public void getEmployeesTest(){
        List list = (List) employeesRep.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void getEmployeesByIdTest() {
       Employees emp = employeesRep.findById(1L).get();
        assertEquals("Игорь", emp.getName());
    }

    @Test
    @Order(4)
    public void editEmployeeTest() {
        Employees emp = employeesRep.findById(1L).get();
        emp.setName("Алекс");
        Employees employeeUpdated =  employeesRep.save(emp);
        assertNotEquals("Игорь", employeesRep.findById(1L).get().getName());
    }

    @Test
    @Order(5)
    public void updateEmployeesTest(){
        Employees emp = employeesRep.findById(2L).get();
        emp.setDepartmentName("Отдел Кадров");
        Employees employeeUpdated =  employeesRep.save(emp);
        assertEquals("Отдел Кадров", emp.getDepartmentName());
    }

    @Test
    @Order(6)
    public void deleteEmployeeTest () {
        employeesRep.deleteById(2L);
        assertThat(employeesRep.existsById(2L)).isFalse();
    }
}