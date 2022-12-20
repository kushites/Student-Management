package com.studentmanagement.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Course;

@Repository
public interface Coursedao extends JpaRepository<Course, Integer> {

}
