package com.shetu.crud.repository;

import com.shetu.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{ //never miss the comma here
    //if we want to make any custom method we have to declare here as follows
    public List<Employee> findAllByOrderByLastNameAsc(); //so it will find All the employees by the last name by ascending order
}
