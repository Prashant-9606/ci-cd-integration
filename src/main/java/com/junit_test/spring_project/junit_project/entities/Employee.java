package com.junit_test.spring_project.junit_project.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    private String name;

    private Integer age;

    private double salary;

//    @ManyToOne
//    @JoinColumn(name = "supervisor_id")
//    private Supervisor supervisor;

    public String toString() {
        return "Name : " + name + "\n" + "Age : " + age + "\n" + "Salary : " + salary;
    }

    public Employee(String name, Integer age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
