package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyService.getCompanyList();
    }

    @GetMapping("/companies/{companyId}")
    public Company getCompany(@PathVariable String companyId) {
        return companyService.getByCompanyId(companyId);
    }

    @PutMapping(value = "/companies/{companyId}")
    public void updateComapany(@PathVariable String companyId,@RequestBody Company company){
        companyService.updateCompany();
    }

    @GetMapping("/companies/{companyId}/employees")
    public List<Employee> getEmployeesById(@PathVariable String companyId){
        return companyService.getEmployeesById(companyId);
    }

    @GetMapping(value = "/companies",params = {"page","pageSize"})
    public List<Company> getCompaniesByPage(@RequestParam int page, @RequestParam int pageSize){
        return companyService.getCompaniesByPage(page,pageSize);
    }

    @PostMapping(value = "/companies")
    public Company createCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }
}
