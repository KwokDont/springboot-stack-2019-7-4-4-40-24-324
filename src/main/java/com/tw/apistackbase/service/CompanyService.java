package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface CompanyService {

    public List<Company> getCompanyList();

    Company getByCompanyId(String companyId);

    void updateCompany();

    List<Employee> getEmployeesById(String s);

    List<Company> getCompaniesByPage(int anyInt, int anyInt1);
}
