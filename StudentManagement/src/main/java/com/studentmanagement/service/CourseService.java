package com.studentmanagement.service;

import org.springframework.stereotype.Service;

import com.studentmanagement.entity.Course;

@Service
public interface CourseService {
	
	public Course saveCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public boolean deleteCourse(Course course);

}
