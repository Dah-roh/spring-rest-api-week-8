package com.example.demo.services;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployees(Employee employee);
    List<Employee> listEmployees();
}
