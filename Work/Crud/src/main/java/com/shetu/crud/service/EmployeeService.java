package com.shetu.crud.service;

import com.shetu.crud.entity.Employee;

import java.util.List;
/*
1.Create = save(Employee employee)
2.Read = List<Employee> findAll()
3.Update =
4.Delete = deleteById(int theId)
5.finding = findById(int theId) -> Employee type
*/

public interface EmployeeService {
    public void save(Employee employee);
    public List<Employee> findAll();
    public void deleteById(int theId);
    public Employee findById(int theId);
}
