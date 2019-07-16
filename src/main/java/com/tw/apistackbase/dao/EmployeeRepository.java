package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeRepository {

    void save(Employee employee);

    Employee findById(String employeeId);

    public List<Employee> getAllEmployees();

    public void deleteById(String employeeId);

    public List<Employee> findAgeMoreThan(int leastAge);

    List<Employee> getEmployeesByPage(int page, int pageSize);

    List<Employee> findByGender(String gender);

    Employee updateById(String employeeId);
}
