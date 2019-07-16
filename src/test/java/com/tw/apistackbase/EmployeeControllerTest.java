package com.tw.apistackbase;

import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void Should_return_employee_when_find_by_id_given_id() throws Exception{
        Employee employee = new Employee("001","liufan",18,"male",8000);

        when(employeeService.findById((anyString()))).thenReturn(employee);

        ResultActions resultActions = mockMvc.perform(get("/employees/{employeeId}",employee.getId()));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("liufan")))
                .andExpect(jsonPath("$.id", is("001")));
    }

    @Test
    public void Should_return_employee_list_when_find_all_employees() throws Exception{

        Employee employee = new Employee("001","liufan",18,"male",8000);
        Employee employee2 = new Employee("002","eddy",22,"male",9000);
        List<Employee> employees = Arrays.asList(employee,employee2);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        ResultActions resultActions = mockMvc.perform(get("/employees"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("001")))
                .andExpect(jsonPath("$[0].name", is("liufan")))
                .andExpect(jsonPath("$[1].id", is("002")))
                .andExpect(jsonPath("$[1].name", is("eddy")));
    }

    @Test
    public void Should_return_two_employee_when_find_employees_by_page() throws Exception{

        Employee employee = new Employee("001","liufan",18,"male",8000);
        List<Employee> employees = Arrays.asList(employee,employee,employee,employee,employee);

        when(employeeService.getEmployeesByPage(1,5)).thenReturn(employees);

        ResultActions resultActions = mockMvc.perform(get("/employees?page=1&pageSize=5"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("001")))
                .andExpect(jsonPath("$[0].age", is(18)))
                .andExpect(jsonPath("$[4].name", is("liufan")));
    }

    @Test
    public void Should_return_new_employee_when_save_employees() throws Exception{

        mockMvc.perform(post("/employees").accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        " \"name\":\"name\",\n" +
                        "  \"age\":18,\n" +
                        "  \"gender\":\"male\",\n" +
                        "  \"salary\":8000\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    public void Should_screen_all_male_employees_when_given_gender() throws Exception{

        Employee employee = new Employee("001","liufan",18,"male",8000);
        List<Employee> employees = Arrays.asList(employee,employee,employee);

        when(employeeService.findByGender("male")).thenReturn(employees);

        ResultActions resultActions = mockMvc.perform(get("/employees?gender=male"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].gender", is("male")))
                .andExpect(jsonPath("$[1].gender", is("male")))
                .andExpect(jsonPath("$[2].gender", is("male")));

    }
}
