package com.junit_test.spring_project.junit_project.service;


import com.junit_test.spring_project.junit_project.entities.Employee;
import com.junit_test.spring_project.junit_project.repo.EmployeeRepo;
import com.junit_test.spring_project.junit_project.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceImplTests {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepo employeeRepo;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCreateEmployee(){

        Employee employee = new Employee(
                "Saksham Sharma",
                24,
                400000
        );

        //Pretending to save employee data into employee table
        when(employeeRepo.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.createEmployee(employee);

        Assertions.assertNotNull(savedEmployee);
        Assertions.assertEquals("Saksham Sharma", savedEmployee.getName());
        Assertions.assertEquals(24, savedEmployee.getAge());
        Assertions.assertEquals(400000, savedEmployee.getSalary());

        verify(employeeRepo, times(1)).save(employee);


    }


    @Test
    public void testGetEmployees(){

        Employee emp1 = new Employee(
                "Dinesh Sura",
                26,
                500000
        );

        Employee emp2 = new Employee(
                "Prabhat Kumar",
                25,
                400000
        );


        List<Employee> employeeList = Arrays.asList(emp1, emp2);


        when(employeeRepo.findAll()).thenReturn(employeeList);

        List<Employee> allEmployee = employeeService.getAllEmployee();


        Assertions.assertNotNull(allEmployee);
        Assertions.assertFalse(allEmployee.isEmpty());
        Assertions.assertEquals("Dinesh Sura", allEmployee.get(0).getName());
        Assertions.assertEquals("Prabhat Kumar", allEmployee.get(1).getName());


        verify(employeeRepo, times(1)).findAll();
    }


    @Test
    public void testemployeeGreaterThan_SUCCESS(){

        var age = 26;

        Employee emp1 = new Employee(
                "Hari",
                28,
                600000
        );

        Employee emp2 = new Employee(
                "Sivamani Jaishankar",
                27,
                600000
        );

        Employee emp3 = new Employee(
                "Ganapathy",
                30,
                80000
        );

        List<Employee> employeeList = Arrays.asList(emp1, emp2, emp3);

        // Mock the repository method
        when(employeeRepo.findEmployeeGreaterThan(age)).thenReturn(employeeList);

        List<Employee> greaterThan26 = employeeRepo.findEmployeeGreaterThan(age);

        // Assertions to verify the results
        Assertions.assertNotNull(greaterThan26);
        Assertions.assertEquals(3, greaterThan26.size());
        Assertions.assertEquals("Hari", greaterThan26.get(0).getName());
        Assertions.assertEquals("Sivamani Jaishankar", greaterThan26.get(1).getName());
        Assertions.assertEquals("Ganapathy", greaterThan26.get(2).getName());  // Corrected index to 2

        // Verify if the method was called once
        verify(employeeRepo, times(1)).findEmployeeGreaterThan(age);
    }


    @Test
    public void testEmployeeGreaterThanNoResults() {
        Employee employee1 = new Employee("John Doe", 30, 50000);
        Employee employee2 = new Employee("Sam Johnson", 25, 45000);

        List<Employee> employeeList = Arrays.asList();  // No employees should match

        when(employeeRepo.findEmployeeGreaterThan(60)).thenReturn(employeeList);

        List<Employee> employees = employeeService.employeeGreaterThan(60);

        Assertions.assertNotNull(employees);
        Assertions.assertEquals(0, employees.size());  // No employees should be found with age > 60

        verify(employeeRepo, times(1)).findEmployeeGreaterThan(60);  // Verify if findEmployeeGreaterThan was called once
    }

}
