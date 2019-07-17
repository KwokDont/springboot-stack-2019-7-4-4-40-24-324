package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.CompanyRepository;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanyList() {
        return companyRepository.getCompanyList();
    }

    @Override
    public Company getByCompanyId(String companyId) {
        return companyRepository.getByCompanyId(companyId);
    }

    @Override
    public void updateCompany() {

    }

    @Override
    public List<Employee> getEmployeesById(String s) {
        return companyRepository.getEmployeesById(s);
    }

    @Override
    public List<Company> getCompaniesByPage(int page, int pageSize) {
        return companyRepository.getCompaniesByPage(page,pageSize);
    }

}
