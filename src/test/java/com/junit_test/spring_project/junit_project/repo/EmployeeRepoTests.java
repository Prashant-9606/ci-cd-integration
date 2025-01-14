package com.junit_test.spring_project.junit_project.repo;


import com.junit_test.spring_project.junit_project.entities.Employee;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class EmployeeRepoTests {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void testFindEmployeeGreaterThan_SUCCESS() {
        Employee employee1 = new Employee("John Doe", 30, 50000);
        Employee employee2 = new Employee("Jane Smith", 40, 60000);
        Employee employee3 = new Employee("Sam Johnson", 25, 45000);

        employeeRepo.save(employee1);
        employeeRepo.save(employee2);
        employeeRepo.save(employee3);

        // Step 2: Call the repository method to find employees greater than a certain age
        List<Employee> employees = employeeRepo.findEmployeeGreaterThan(30);

        // Step 3: Perform assertions to verify the method works as expected
        assertNotNull(employees);
        assertEquals(1, employees.size());
    }


    @Test
    public void testFindEmployeeGreaterThan_FAILURE(){
        Employee employee1 = new Employee("John Doe", 30, 50000);
        Employee employee2 = new Employee("Jane Smith", 40, 60000);
        Employee employee3 = new Employee("Sam Johnson", 25, 45000);

        employeeRepo.save(employee1);
        employeeRepo.save(employee2);
        employeeRepo.save(employee3);

        List<Employee> employees = employeeRepo.findEmployeeGreaterThan(40);

        // Step 3: Perform assertions to verify the method works as expected
        assertTrue(employees.isEmpty());
    }

}
