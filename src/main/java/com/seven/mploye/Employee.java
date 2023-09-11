package com.seven.mploye;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    public Employee(long id, String name, String email, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }
    public Employee(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    public String name;
    public String email;
    public String department;
}
