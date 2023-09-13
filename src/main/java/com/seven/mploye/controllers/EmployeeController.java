package com.seven.mploye.controllers;

import com.seven.mploye.Employee;
import com.seven.mploye.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees/")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping({"list",""})
    public ModelAndView getEmployee2(){
        ModelAndView mav = new ModelAndView("parent");
        mav.addObject("fragment", "list_employees");
        mav.addObject("employees", employeeRepository.findAll());
        return mav;
    }
    @GetMapping("create")
    public ModelAndView createEmployeeView(){
        ModelAndView mav = new ModelAndView("parent");
        mav.addObject("fragment", "create_employees");
        mav.addObject("employee", new Employee());
        return mav;
    }

    @PostMapping("create")
    public String createEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees/list";
    }
}