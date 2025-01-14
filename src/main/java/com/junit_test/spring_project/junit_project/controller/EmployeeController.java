package com.junit_test.spring_project.junit_project.controller;


import com.junit_test.spring_project.junit_project.entities.Employee;
import com.junit_test.spring_project.junit_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Employee> putEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return ResponseEntity.of(Optional.ofNullable(allEmployee));
    }


    @GetMapping("/{age}")
    public ResponseEntity<List<Employee>> employeeGreaterThan(@PathVariable Integer age){
        List<Employee> employeesWithAgeGreaterThan = employeeService.employeeGreaterThan(age);
        return ResponseEntity.ok(employeesWithAgeGreaterThan);
    }
}
