package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findById(String employeeId);

    public List<Employee> getAllEmployees();

    public void deleteById(String employeeId);

    public List<Employee> findAgeMoreThan(int leastAge);

    List<Employee> getEmployeesByPage(int page, int pageSize);

    List<Employee> findByGender(String gender);
}
