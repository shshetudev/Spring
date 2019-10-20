package com.shetu.simplecrudjavaguides.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student_table")
public class Student {
    /*
     * fields: id,name,email,phoneNo , getter,setter,constructor
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //adding default validation
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    //adding default validation
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;

    ///constructors: default, args(name,email)
    public Student(){}

    public Student(@NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "Email is mandatory") String email) {
        this.name = name;
        this.email = email;
    }
    //getters and setters


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

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
}
