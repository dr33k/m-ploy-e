package com.seven.mploye.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping
    public String getEmployee(Model model){
        return "Emelie";
    }
    @GetMapping("/w")
    public String getEmployee2(Model model){
        return "new Employee of the Ivantoe tower";
    }
}