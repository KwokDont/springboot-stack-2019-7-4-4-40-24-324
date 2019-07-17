package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface CompanyRepository {

    public List<Company> getCompanyList();

    Company getByCompanyId(String companyId);

    List<Employee> getEmployeesById(String s);

    List<Company> getCompaniesByPage(int page, int pageSize);

    Company saveCompany(Company company);
}
