package com.studentmanagement.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Student;

@Repository
public interface Studentdao extends JpaRepository<Student, Integer>{
     public Student findByName(String name);
}
