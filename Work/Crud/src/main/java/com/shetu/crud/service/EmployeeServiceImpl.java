package com.shetu.crud.service;

import com.shetu.crud.entity.Employee;
import com.shetu.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* 1.use annotation: @Service
* 2.use field injection for Repository
* 3. for List type and findById() take special care
* */
@Service
public class EmployeeServiceImpl implements EmployeeService{
   @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
    employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        ///since it is list type so it will return a list
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public Employee findById(int theId) {
      /*
      * 1.create two object : Employee type and Optional<Employee> type which will fetch the result using the repository, and assign the value to employee
      * using result.get()
      * 2.if optional type variable has a value then assign in the other variable using get() method
      * 3.at last return the Employee type data
      * */
      Employee employee = null;
      Optional<Employee> result = employeeRepository.findById(theId);
      if(result.isPresent()){
          employee = result.get();
      }else {
          throw new RuntimeException("Did not found the id - "+theId); ///throw keyword will be used at first, and new RuntimeException
      }
      return employee;
    }
}
