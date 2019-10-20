package com.shetu.crudbyapi.dao;

import com.shetu.crudbyapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
