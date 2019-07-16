package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CompanyRepositoryImpl implements CompanyRepository{

    public static final int PAGE_SKIP = 1;
    static private List<Employee> employeesList = new ArrayList<>();

    static {
        Employee employee = new Employee("eddy", 22, "male", 8000);
        employeesList.addAll(Arrays.asList(employee,employee,employee,employee,employee));
    }

    static private Company company = new Company("1", "alibaba", 200, employeesList);
    static private List<Company> companyList = new ArrayList<>();

    static {
        companyList.add(company);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyList;
    }

    @Override
    public Company getByCompanyId(String companyId) {
        return companyList.stream().filter(company1 -> company1.getId().equals(companyId)).findFirst().get();
    }
}
