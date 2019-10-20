package com.shetu.simplecrudjavaguides.repository;

import com.shetu.simplecrudjavaguides.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

//find by name
    List<Student> findByName(String name);
}
