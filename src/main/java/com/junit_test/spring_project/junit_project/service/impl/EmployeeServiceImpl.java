package com.junit_test.spring_project.junit_project.service.impl;

import com.junit_test.spring_project.junit_project.entities.Employee;
import com.junit_test.spring_project.junit_project.exception.ResourceNotFoundException;
import com.junit_test.spring_project.junit_project.repo.EmployeeRepo;
import com.junit_test.spring_project.junit_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public Employee createEmployee(Employee employee) {
        System.out.println(employee);
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> employeeGreaterThan(Integer age) {
        return employeeRepo.findEmployeeGreaterThan(age);
    }
}
