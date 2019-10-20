package com.shetu.crud.controller;

import com.shetu.crud.entity.Employee;
import com.shetu.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 1.use @Controller annotation and autowire : employeeService here
 * 2.use "/employees" mapping for requesting
 * 3.Create =>/save Read=>/list Update=> Delete=> Find=>/showFormForAdd
 * */
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //Create : We need PostMapping for saving
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) { //data binding from View page
        //save the employee
        employeeService.save(employee);
        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
    //Read : We need GetMapping for getting the list

    //Delete:

    //ShowFormForAdd:

}
