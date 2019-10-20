package com.shetu.simplecrudjavaguides.controller;

import com.shetu.simplecrudjavaguides.domain.Student;
import com.shetu.simplecrudjavaguides.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students/") //we will make new folder
public class StudentController {
    //inserting repository and making it final
    //using constructor injection
   private final StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //create
    @GetMapping("signup")
    public String showSignUpForm(Student student){
        return "add-student";
    }
    @PostMapping("add") //@Valid is same as @ModelAttribute , dynamic validation
    public String addStudent(@Valid Student student, BindingResult result, Model model){
    if(result.hasErrors()){
        return "add-student";
    }
    //BindingResult initializes dynamic checking
        //if there is no error
        studentRepository.save(student);
    return "redirect:list";
    }

    //read
@GetMapping("list")
    public String showStudentList(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return "student-list";
}

    //edit
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id,Model model){
        //dynamic validation
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: "+id));
    model.addAttribute("student",student);
    return "update-student";
    }

    //update
    //whenever we want anything we have to request using @RequestParam or @PathVariable
    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id,@Valid Student student,BindingResult result,Model model){
    if(result.hasErrors()){
        student.setId(id);
        return "update-student";
    }
    //if does not have any error
        studentRepository.save(student);
    //sending a list
    model.addAttribute("students",studentRepository.findAll());
    return "student-list";
    }
    //delete
    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id,Model model){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid Student Id: "+id));
        studentRepository.delete(student);
        model.addAttribute("students",studentRepository.findAll());
        return "student-list";
    }
}
