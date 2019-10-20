package com.shetu.crudbyapi.service;

import com.shetu.crudbyapi.dao.StudentRepository;
import com.shetu.crudbyapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* inject the repository
* service will only send data using repository
* */
@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> studentList() {

     return studentRepository.findAll();
    }

    @Override
    public void save(Student student) { //there will be no return since it is void type
        //we are saving the student using the thymeleaf view
        studentRepository.save(student);
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> tempStudent = studentRepository.findById(theId);
        Student student = null; //it should be null
        if (tempStudent.isPresent()){
            student = tempStudent.get();
        }else{
            //we did not find the student
            throw new RuntimeException("Did not find student id -"+ theId);
        }
        return student;
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }



}
