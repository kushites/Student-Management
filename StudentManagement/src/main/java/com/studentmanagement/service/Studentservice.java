package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;

public interface Studentservice {
	
	public Student saveStudent(Student student);
	
	public Student getStudent(int id);
	
	public Student getStudentbyname(String name);
	
	public boolean deleteStudent(Student student);
	
	public Student updateStudentcourse(Course course);
	
	public List<Student> getallStudentbyCourse(Course course);

}
