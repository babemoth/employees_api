package com.example.Employees;

import com.example.Employees.model.Employees;
import com.example.Employees.repository.EmployeesRep;
import com.example.Employees.service.EmployeesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeesController.class)
@SpringBootTest
public class EmployeesControllerTest {

    @Autowired
    private EmployeesService employeesService;

    @MockBean
    EmployeesRep employeesRep;

    @Test
     public void createEmployeeTest(){
        Employees emp = new Employees();
        emp.setName("Kate");
        emp.setLastName("Povisheva");
        emp.setPhoneNumber("89999472837");
        emp.setDepartmentName("Отдел Образования");
        when(employeesRep.save(emp)).thenReturn(emp);
        assertEquals(emp, employeesService.saveEmployees(emp));
    }

//    @Autowired
//    private EmployeesController employeesController;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    EmployeesService employeesService;


//    @Test
//    public void createEmployeeTest() throws Exception {
////        Employees emp = new Employees();
////
////        boolean isEmployeeCreated = employeesController.createEmployee("Kate", "Povisheva", "89999472837","Отдел Образования");
////
////        Assert.assertTrue(isEmployeeCreated);
//        Employees emp = new Employees();
//        emp.setName("Kate");
//        emp.setLastName("Povisheva");
//        emp.setPhoneNumber("89999472837");
//        emp.setDepartmentName("Отдел Образования");
//
//        when(employeesService.saveEmployees(emp)).thenReturn(emp);
//
//
//        mockMvc.perform ((RequestBuilder) get("/api/create_employee"))
//                .contentType(APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isCreated());
//
//        Mockito.verify(employeesService, times(1)).saveEmployees(emp);
//    }

//    @Test
//    public void getEmployeesByIdTest(){
//        long id = 5;
//        when(employeesController.getEmployeesById(id)).thenReturn(Stream.of(new Employees("Кате", "Povisheva", "89999463993", "Отдел Продаж")).collect(Collectors.toList()));
//        assertEquals(5,employeesService.getEmployees(id).toString());
//    }



    //get by id
//    @Test
//    public void getEmployeesTest() throws Exception {
//
//        Employees employees = new Employees();
//        employees.setName("Майк");
//        employees.setLastName("Вазовски");
//        employees.setPhoneNumber("79999450339");
//        employees.setDepartmentName("Отдел Продаж");
//
//        given(employeesController.getEmployeesById(employees.getId())).willReturn(employees);
//
//        mockMvc.perform(get(employees.getId()
//                .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("name", is(employees.getName()));

        //when(employeesService.getEmployees((long) anyInt())).thenReturn(Optional.of(employees));


//        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/{employeesId}")
//                .contentType(APPLICATION_JSON)
//                .andExpect(status().isOk())

//
//    }

//    @Test
//    public void saveEmployeesTest() throws Exception {
//        Employees employees = new Employees();
//        employees.setName("Майк");
//        employees.setLastName("Вазовски");
//        employees.setPhoneNumber("79999450339");
//        employees.setDepartmentName("Отдел Продаж");
//
//        when(employeesService.saveEmployees(any(Employees.class))).thenReturn(employees);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCr)
//    }


//    @MockBean
//    private EmployeesService employeesService;
//
//    @Test
//    public void getEmployeesTest(){
//
//    }
}
