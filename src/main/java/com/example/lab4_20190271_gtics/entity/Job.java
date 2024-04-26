package com.example.lab4_20190271_gtics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobid;

    @Column(name = "job_title", nullable = false)
    private String jobtitle;

    @Column(name = "min_salary", nullable = false)
    private String minsalary;
    @Column(name = "max_salary", nullable = false)
    private String maxsalary;

}
