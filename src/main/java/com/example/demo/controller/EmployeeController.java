package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/")
@RestController
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //debug level
    // log.debug()
    //info level
//    log.info()
    //warning level
//    log.warn()
    //error level
//    log.error()
    @GetMapping("employees")
    public ResponseEntity<List<Employee>> viewAllEmployees(){
        List<Employee> listOfEmployees = employeeService.listEmployees();
        log.info("I am at line 27 and the employee list is "+ listOfEmployees.toString());
        return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
    }

    @PostMapping("add_employees")
    public ResponseEntity<List<Employee>> addNewEmployee(@RequestBody Employee employee){
        employeeService.addEmployees(employee);
        List<Employee> listOfEmployees = employeeService.listEmployees();
        return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
    }
}
