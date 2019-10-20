package com.shetu.crudbyapi.service;

import com.shetu.crudbyapi.model.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/*
* 1.methods for finding all the students
* 2.
* */
public interface StudentService {
    List<Student> studentList();
    //Create student
    public void save(Student student);

    //find the student by id
    public Student findById(int theId);

    //delete the student by id
    public void deleteById(int theId);



}
