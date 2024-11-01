package com.ssw.controllertest;

import com.ssw.controller.EmployeeController;
import com.ssw.entity.Employee;
import com.ssw.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testCreateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("suyash");
        employee.setPassword("password");
        employee.setMail("suyash@gmail.com");
        employee.setPhone(1234567890L);
        employee.setAddress("address");

        Mockito.when(employeeService.createEmployee(Mockito.any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/employee-api/createEmployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"employeeName\":\"suyash\",\"password\":\"password\",\"mail\":\"suyash@gmail.com\",\"phone\":1234567890,\"address\":\"address\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.employeeName", is("suyash")))
                .andExpect(jsonPath("$.password", is("password")))
                .andExpect(jsonPath("$.mail", is("suyash@gmail.com")))
                .andExpect(jsonPath("$.phone", is(1234567890)))
                .andExpect(jsonPath("$.address", is("address")));
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setEmployeeName("suyash");
        employee1.setPassword("password");
        employee1.setMail("suyash@gmail.com");
        employee1.setPhone(1234567890L);
        employee1.setAddress("address1");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setEmployeeName("Daemon");
        employee2.setPassword("password123");
        employee2.setMail("daemon@gmail.com");
        employee2.setPhone(9876543210L);
        employee2.setAddress("address2");

        List<Employee> employees = Arrays.asList(employee1, employee2);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employee-api/getAllEmployees"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].employeeName", is("suyash")))
                .andExpect(jsonPath("$[0].password", is("password")))
                .andExpect(jsonPath("$[0].mail", is("suyash@gmail.com")))
                .andExpect(jsonPath("$[0].phone", is(1234567890)))
                .andExpect(jsonPath("$[0].address", is("address1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].employeeName", is("Daemon")))
                .andExpect(jsonPath("$[1].password", is("password123")))
                .andExpect(jsonPath("$[1].mail", is("daemon@gmail.com")))
                .andExpect(jsonPath("$[1].phone", is(9876543210L)))
                .andExpect(jsonPath("$[1].address", is("address2")));
    }

    @Test
    public void testFindEmployeeById() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("suyash");
        employee.setPassword("password");
        employee.setMail("suyash@gmail.com");
        employee.setPhone(1234567890L);
        employee.setAddress("address");

        Mockito.when(employeeService.findEmployeeById(1)).thenReturn(employee);

        mockMvc.perform(get("/employee-api/findEmployeeById/1"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.employeeName", is("suyash")))
                .andExpect(jsonPath("$.password", is("password")))
                .andExpect(jsonPath("$.mail", is("suyash@gmail.com")))
                .andExpect(jsonPath("$.phone", is(1234567890)))
                .andExpect(jsonPath("$.address", is("address")));
    }

    @Test
    public void testUpdateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("suyash");
        employee.setPassword("password");
        employee.setMail("suyash@gmail.com");
        employee.setPhone(1234567890L);
        employee.setAddress("address");

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(1);
        updatedEmployee.setEmployeeName("suyash updated");
        updatedEmployee.setPassword("newpassword");
        updatedEmployee.setMail("suyash.updated@gmail.com");
        updatedEmployee.setPhone(1234567890L);
        updatedEmployee.setAddress("new address");

        Mockito.when(employeeService.updateEmployee(Mockito.any(Employee.class), Mockito.eq(1))).thenReturn(updatedEmployee);

        mockMvc.perform(put("/employee-api/updateEmployee/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"employeeName\":\"suyash updated\",\"password\":\"newpassword\",\"mail\":\"suyash.updated@gmail.com\",\"phone\":1234567890,\"address\":\"new address\"}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.employeeName", is("suyash updated")))
                .andExpect(jsonPath("$.password", is("newpassword")))
                .andExpect(jsonPath("$.mail", is("suyash.updated@gmail.com")))
                .andExpect(jsonPath("$.phone", is(1234567890)))
                .andExpect(jsonPath("$.address", is("new address")));
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        Mockito.when(employeeService.deleteEmployee(1)).thenReturn("Employee deleted successfully");

        mockMvc.perform(delete("/employee-api/deleteEmployee/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee deleted successfully"));
    }
}
