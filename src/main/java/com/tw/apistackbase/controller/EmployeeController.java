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
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/employees",params = {"page","pageSize"})
    public List<Employee> getEmployeesByPage(@RequestParam(value = "page")int page,@RequestParam(value = "pageSize")int pageSize){
        return employeeService.getEmployeesByPage(page,pageSize);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @GetMapping(value = "/employees",params = "gender")
    public List<Employee> findEmployeesByGender(@RequestParam(value = "gender") String gender){
        return employeeService.findByGender(gender);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable String employeeId){
        return employeeService.findById(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployeeById(@PathVariable String employeeId){
        return employeeService.updateById(employeeId);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable String employeeId){
        return employeeService.deleteById(employeeId);
    }

    @GetMapping(value = "/employees",params = "leastAge")
    public List<Employee> findAgeMoreThan(@RequestParam("leastAge") int leastAge) {
        return employeeService.findAgeMoreThan(leastAge);
    }
}
