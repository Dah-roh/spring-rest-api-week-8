package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "names")
    private String name;
    @Column(name = "salaries")
    private double salary;
    @Column(name = "level")
    private String level;


}
