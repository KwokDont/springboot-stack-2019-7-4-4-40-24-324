package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired()
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable String employeeId){
        return employeeService.findById(employeeId);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable String employeeId){
        employeeService.deleteById(employeeId);
    }

    @GetMapping(value = "/employees",params = "leastAge")
    public List<Employee> findAgeMoreThan(@RequestParam int leastAge) {
        return employeeService.findAgeMoreThan(leastAge);
    }
}
