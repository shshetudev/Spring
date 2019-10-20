package com.shetu.crudbyapi.controller;

import com.shetu.crudbyapi.model.Student;
import com.shetu.crudbyapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
 * 1.Inject Service into Controller
 * 2.Insert Mapping: GetMapping and PostMapping
 * 3.
 * Since We want to find all the studnets so we have to take Student Type List
 * Inside the GetMapping give a url and first: create a student and set some values , create an ArrayList and add the student to the List
 * 4.return the List
 *
 * For specific mapping:
 * 1.
 * */

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    /*
     * 1. GetMapping and PostMapping for student Adding
     * 2. For Both time we have to pass model as argument
     * 3. At first check out what is the mapping, using that mapping just use the
     * controller
     * */
    @GetMapping("/")
    public String studentForm(Model model) {
        //create model attribute to bind form data
        Student student = new Student();
        //bind data using model
        model.addAttribute("student", student); //object name as string, object
        return "/student-form";
    }

    //For saving student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) { //Model is only used for GetMapping where as When we use PostMapping we have to use @ModelAttribute to bind the data
        //save the student
        studentService.save(student);
        //redirect to the specific student list
        return "redirect:/student-list";
    }

    //For Showing the student List
    @GetMapping("/student-list")
    public String showStudentList(Model model) {
        //get employees from the db
        List<Student> studentList = studentService.studentList(); //we will not create any arraylist here because all the values are captured for the database that's why we have to use from service
        //add to the spring model
        model.addAttribute("studentList", studentList); //unique object name in string, Object name
        //return to the html page: student-list
        return "/student-list"; //never miss the / here , if we do not
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        Student tempStudent = studentService.findById(id);
    //throw exception if null
        if(tempStudent == null){
            throw  new RuntimeException("Student id not found - "+id);
        }
        studentService.deleteById(id);
        return "Delete Student id- "+id;
    }
}
