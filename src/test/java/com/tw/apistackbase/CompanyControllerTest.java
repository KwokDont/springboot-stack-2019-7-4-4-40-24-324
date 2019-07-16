package com.tw.apistackbase;

import com.tw.apistackbase.controller.CompanyController;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Test
    public void Should_return_company_list_when_find_all_company() throws Exception{

        Employee employee = new Employee("002","eddy",22,"male",9000);
        List<Employee> employees = Arrays.asList(employee,employee,employee);
        Company company = new Company("1111", "alibaba", 200, employees);
        Company company2 = new Company("2222", "tencent", 200, employees);
        List<Company> companies = Arrays.asList(company,company2);

        when(companyService.getCompanyList()).thenReturn(companies);

        ResultActions resultActions = mockMvc.perform(get("/companies"));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("1111")))
                .andExpect(jsonPath("$[1].companyName", is("tencent")));
    }
}
