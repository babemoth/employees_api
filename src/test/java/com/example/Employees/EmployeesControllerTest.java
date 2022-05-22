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
public class EmployeesControllerTest {

//    @Autowired
//    private EmployeesService employeesService;

//    @MockBean
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
    public void testReadAll(){
        List list = (List) employeesRep.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void testRead() {
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
    @Order(5)
    public void testDelete () {
        employeesRep.deleteById(1L);
        assertThat(employeesRep.existsById(1L)).isFalse();
    }









//        @Test
//    public void getEmployeesTest(){
//        Employees emp1 = new Employees();
//        emp1.setName("Маргарита");
//        emp1.setLastName("Мордашкина");
//        emp1.setPhoneNumber("89899883647");
//        emp1.setDepartmentName("Отдел Образования");
//        Employees emp2 = new Employees();
//        emp2.setName("Ананстасия");
//        emp2.setLastName("Кирова");
//        emp2.setPhoneNumber("89899482857");
//        emp2.setDepartmentName("Отдел Продаж");
//        when(employeesRep.findAll()).thenReturn(Stream.of(emp1,emp2).collect(Collectors.toList()));
//        assertEquals(2,employeesService.retrieveEmployees().size());
//    }

//    @Test
//     public void createEmployeeTest(){
//        Employees emp = new Employees();
//        emp.setId(1L);
//        emp.setName("Kate");
//        emp.setLastName("Povisheva");
//        emp.setPhoneNumber("89999472837");
//        emp.setDepartmentName("Отдел Образования");
//        when(employeesRep.save(emp)).thenReturn(emp);
//        assertEquals(emp, employeesService.saveEmployees(emp));
//    }


//    @Test
//    public void getEmployeesByIdTest(){
//        Employees emp = new Employees();
//        emp.setId(1L);
//        emp.setName("Kate");
//        emp.setLastName("Povisheva");
//        emp.setPhoneNumber("89999472837");
//        emp.setDepartmentName("Отдел Образования");
//        Employees emp1 = new Employees();
//        emp1.setId(2L);
//        emp1.setName("Lol");
//        emp1.setLastName("Rer");
//        emp1.setPhoneNumber("89999472837");
//        emp1.setDepartmentName("Отдел Образования");
////        when(employeesRep.findById(2L)).thenReturn(Stream.of(emp).collect(Collectors.toList()));
//        Mockito.when(employeesRep.findById(2L)).thenReturn(Optional.of(emp));
//        assertEquals(emp, Mockito.when(employeesService.getEmployees(4L)).thenReturn(Optional.of(emp)));
//    }


//    @Test
//    public void editEmployeeTest(){
//        Employees emp = new Employees();
//        emp.setId(4L);
//        emp.setName("Kate");
//        emp.setLastName("Povisheva");
//        emp.setPhoneNumber("89999472837");
//        emp.setDepartmentName("Отдел Образования");
//        when(employeesRep.save(emp)).thenReturn(emp);
//        emp.setDepartmentName("Отдел Культуры");
//        assertEquals(emp,employeesService.updateEmployees((long) 1, emp));


//        Employees emp = new Employees();
//        emp.setId(1L);
//        emp.setName("El");
//        emp.setLastName("Povisheva");
//        emp.setPhoneNumber("89999472837");
//        emp.setDepartmentName("Отдел Образования");
//        Employees emp1 = new Employees();
//        emp1.setId(2L);
//        emp1.setName("Max");
//        emp1.setLastName("Lol");
//        emp1.setPhoneNumber("89999472837");
//        emp1.setDepartmentName("Отдел Образования");
//        Employees employee = employeesRep.findById(1L).get();
//        employee.setName("Mem");
//        Employees employeeUpdated =  employeesRep.save(employee);
//        Assertions.assertThat(employeeUpdated.getName()).isEqualTo("Mem");

//    }

        //update employee's department
//    @Test
//    public void updateEmployeesTest(){

//        Employees employee = Employees.builder()
//                .firstName("Ramesh")
//                .lastName("Fadatare")
//                .email("ramesh@gmail.com")
//                .build();
//
//        employeeRepository.save(employee);
//
//        Assertions.assertThat(employee.getId()).isGreaterThan(0);

//        Employees employee = employeesRep.findById(1L).get();
//
//        employee.setDepartmentName("Отдел Кадров");
//
//        Employees employeeUpdated =  employeesRep.save(employee);
//
//        Assertions.assertThat(employeeUpdated.getDepartmentName()).isEqualTo("Отдел Кадров");
//    }
//
//    @Test
//    public  void deleteEmployeeTest(){
//        Employees emp = new Employees();
//        emp.setId((long) 1);
//        emp.setName("Елизавета");
//        emp.setLastName("Кислова");
//        emp.setPhoneNumber("89899844957");
//        emp.setDepartmentName("Отдел Продаж");
//        Employees emp1 = new Employees();
//        emp1.setId((long) 2);
//        emp1.setName("Елизавета");
//        emp1.setLastName("Кислова");
//        emp1.setPhoneNumber("89899844957");
//        emp1.setDepartmentName("Отдел Продаж");
//        employeesRep.deleteById(1L);
////        verify(employeesRep,times(1)).delete(emp);
//        when(employeesRep.findAll()).thenReturn(Stream.of(emp,emp1).collect(Collectors.toList()));
//        assertEquals(1,employeesService.retrieveEmployees().size());
//    }
}