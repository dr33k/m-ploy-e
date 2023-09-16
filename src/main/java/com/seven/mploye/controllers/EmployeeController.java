package com.seven.mploye.controllers;

import com.seven.mploye.Employee;
import com.seven.mploye.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees/")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping({"list",""})
    public ModelAndView getEmployee(){
        ModelAndView mav = new ModelAndView("parent");
        mav.addObject("fragment", "list_employees");
        mav.addObject("employees", employeeRepository.findAll());
        return mav;
    }

    @GetMapping("view")
    public ModelAndView getView(@RequestParam("id") Long id, @RequestParam("template") String template){
        if(template == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        ModelAndView mav = new ModelAndView("parent");
        if(template.equals("create")){
            mav.addObject("fragment", "create_employees");
            mav.addObject("employee", new Employee());
            return mav;
        }
        mav.addObject("fragment", String.format("%s_employees",template));

        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mav.addObject("employee", employee);
        return mav;
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute @Valid Employee employee, BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("fragment", (employee.id == null)? "create_employees" : "update_employees");
            return "parent";
        }
        employeeRepository.save(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("delete")
    public String deleteEmployee(@RequestParam("id") Long id){
       employeeRepository.deleteById(id);
       return "redirect:/employees/list";
    }
}