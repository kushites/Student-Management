package com.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.studentmanagement.entity.Course;
import com.studentmanagement.exceptions.CourseNotFound;
import com.studentmanagement.respository.Coursedao;

public class CourseServiceimpl implements CourseService{
	
	@Autowired
	private Coursedao coursedao;

	@Override
	public Course saveCourse(Course course) {
		
		return coursedao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		Optional<Course> opt = coursedao.findById(course.getCid());
		if(opt.isEmpty()) {
			throw new CourseNotFound("Course not Found");
		}
		return opt.get();
	}

	@Override
	public boolean deleteCourse(Course course) {
		
		Optional<Course> opt= coursedao.findById(course.getCid());
		if(opt.isEmpty()) {
			throw new CourseNotFound("Course Not Found");
		}
		return true;
	}

	

}
