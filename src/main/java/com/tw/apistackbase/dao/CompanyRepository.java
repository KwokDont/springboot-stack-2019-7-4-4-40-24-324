package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;

import java.util.List;

public interface CompanyRepository {

    public List<Company> getCompanyList();
}
