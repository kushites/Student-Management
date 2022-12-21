package com.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;

@Service
public interface Studentservice {
	
	public Student saveStudent(Student student);
	
	public Student getStudent(int id);
	
	public Student getStudentbyname(String name);
	
	public List<Course> getCourses(String studentname);
	
	public boolean deleteStudent(Student student);
	
	public boolean deleteCourseOfStudent(String studentname, String coursename);
	
	public Student updateStudent(Student student);
	
	public Student updateStudentcourse(Student student, Course course);
	
	public List<Student> getallStudentbyCourse(String coursename);

}
