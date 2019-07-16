package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.EmployeeRepository;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired()
    @Qualifier("employeeRepositoryImpl")
    private EmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {
        repository.save(employee);
        return employee;
    }

    @Override
    public Employee findById(String employeeId) {
        return repository.findById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    @Override
    public String deleteById(String employeeId) {
        repository.deleteById(employeeId);
        return employeeId;
    }

    @Override
    public List<Employee> findAgeMoreThan(int leastAge) {
        return repository.findAgeMoreThan(leastAge);
    }

    @Override
    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        return repository.getEmployeesByPage(page, pageSize);
    }

    @Override
    public List<Employee> findByGender(String gender) {
        return repository.findByGender(gender);
    }

    @Override
    public Employee updateById(String employeeId) {
        return repository.updateById(employeeId);
    }
}
