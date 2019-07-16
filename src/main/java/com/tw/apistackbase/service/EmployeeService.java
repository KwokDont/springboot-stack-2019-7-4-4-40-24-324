package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    Employee findById(String employeeId);

    public List<Employee> getAllEmployees();

    public void deleteById(String employeeId);

    public List<Employee> findAgeMoreThan(int leastAge);
}
