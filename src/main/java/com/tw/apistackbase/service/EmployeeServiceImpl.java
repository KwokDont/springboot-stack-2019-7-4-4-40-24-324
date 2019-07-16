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
    public void save(Employee employee) {
        repository.save(employee);
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
    public void deleteById(String employeeId) {
        repository.deleteById(employeeId);
    }

    @Override
    public List<Employee> findAgeMoreThan(int leastAge) {
        return repository.findAgeMoreThan(leastAge);
    }
}
