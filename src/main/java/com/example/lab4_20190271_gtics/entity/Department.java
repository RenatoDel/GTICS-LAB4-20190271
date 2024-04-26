package com.example.lab4_20190271_gtics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentid;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Column(name = "department_name", nullable = false)
    private String departmentname;

}
