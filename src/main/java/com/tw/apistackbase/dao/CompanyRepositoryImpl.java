package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyRepositoryImpl implements CompanyRepository{

    public static final int PAGE_SKIP = 1;
    static private List<Employee> employeesList = new ArrayList<>();

    static {
        Employee employee = new Employee("eddy", 22, "male", 8000);
        employeesList.addAll(Arrays.asList(employee,employee,employee,employee,employee));
    }

    static private Company company = new Company("1", "alibaba", 200, employeesList);
    static private Company company2 = new Company("2", "tencent", 199, employeesList);
    static private List<Company> companyList = new ArrayList<>();

    static {
        companyList.add(company);
        companyList.add(company2);
        companyList.add(company);
        companyList.add(company2);
        companyList.add(company2);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyList;
    }

    @Override
    public Company getByCompanyId(String companyId) {
        return companyList.stream().filter(company1 -> company1.getId().equals(companyId)).findFirst().get();
    }

    @Override
    public List<Employee> getEmployeesById(String companyId) {
        return companyList.stream().filter(company1 -> company1.getId().equals(companyId)).findFirst().get().getEmployees();
    }

    @Override
    public List<Company> getCompaniesByPage(int page, int pageSize) {
        List<Company> companies = getCompanyList();
        int begin = (page - 1) * pageSize;
        int end = (begin + pageSize + 1) > companies.size() ? companies.size() - 1 : (begin + pageSize -1);
        List<Company> returnList = new ArrayList<>();
        for(int i = begin ; i <= end ; i++){ returnList.add(companies.get(i)); }
        return returnList;
    }

    @Override
    public Company saveCompany(Company company) {
        companyList.add(company);
        return company;
    }
}
