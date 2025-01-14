package com.junit_test.spring_project.junit_project.service;

import com.junit_test.spring_project.junit_project.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    List<Employee> employeeGreaterThan(Integer age);
}
