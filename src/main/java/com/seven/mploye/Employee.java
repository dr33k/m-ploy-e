package com.seven.mploye;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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
    @NotBlank(message = "Enter a valid name")
    public String name;
    @Email(message = "Enter a valid email")
    @NotBlank(message = "Enter a valid email")
    public String email;
    public String department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
