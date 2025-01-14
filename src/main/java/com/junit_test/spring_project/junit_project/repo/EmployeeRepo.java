package com.junit_test.spring_project.junit_project.repo;

import com.junit_test.spring_project.junit_project.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.age > :age")
    List<Employee> findEmployeeGreaterThan(@Param("age") Integer age);

}
