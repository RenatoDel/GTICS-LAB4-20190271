package com.example.lab4_20190271_gtics.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int shipperId;


    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phonenumber;
    @Column(name = "hire_date", nullable = false)
    private Date hiredate;
    @Column(name = "salary", nullable = false)
    private Float salary;
    @Column(name = "commission_pct", nullable = false)
    private String commision;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;



}
