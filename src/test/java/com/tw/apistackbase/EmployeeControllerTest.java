package com.tw.apistackbase;

import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void Should_return_message_when_find_by_id_given_id() throws Exception{
        Employee employee = new Employee("001","liufan",18,"male");

        when(employeeService.findById((anyString()))).thenReturn(employee);

        ResultActions resultActions = mockMvc.perform(get("/employees/{employeeId}",employee.getId()));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("liufan")))
                .andExpect(jsonPath("$.id", is("001")));
    }
}
