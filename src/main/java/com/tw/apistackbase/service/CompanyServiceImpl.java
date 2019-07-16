package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.CompanyRepository;
import com.tw.apistackbase.model.Company;
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
}
