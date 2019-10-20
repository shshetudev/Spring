package com.shetu.crudbyapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="student_tbl")
public class Student {
//fields: name, roll, age
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int roll;
    private int age;



}
