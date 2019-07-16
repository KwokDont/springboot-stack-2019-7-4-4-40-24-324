package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final static Map<String, Employee> employees = new HashMap<>();

    static {
        addEmployee("fan",20,"male",1000);
        addEmployee("liu",22,"male",2000);
        addEmployee("dean",26,"female",3000);
        addEmployee("young",31,"male",4000);
    }

    public static void addEmployee(String name,int age, String gender, double salary){
        String key = UUID.randomUUID().toString();
        Employee employee = new Employee(key, name, age, gender, salary);
        employees.put(key,employee);
    }

    public void save(Employee employee){
        if(employees.containsKey(employee.getId())){
            employees.put(employee.getId(),employee);
        }else{
            addEmployee(employee.getName(),employee.getAge(),employee.getGender(),employee.getSalary());
        }
    }

    public Employee findById(String employeeId){
        return employees.get(employeeId);
    }

    public List<Employee> getAllEmployees(){
        return new ArrayList<>(employees.values());
    }

    public void deleteById(String employeeId) {
        employees.remove(employeeId);
    }

    public List<Employee> findAgeMoreThan(int leastAge) {
        return getAllEmployees().stream().filter(employee -> employee.getAge() > leastAge).collect(Collectors.toList());
    }
}
