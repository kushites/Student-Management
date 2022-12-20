package com.studentmanagement.service;

import com.studentmanagement.entity.Course;

public interface CourseService {
	
	public Course saveCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public boolean deleteCourse(Course course);

}
