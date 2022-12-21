package com.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;
import com.studentmanagement.exceptions.StudentNotFound;
import com.studentmanagement.respository.Studentdao;

public class Studentserviceimpl implements Studentservice{

	@Autowired
	private Studentdao studentdao;
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentdao.save(student);
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentdao.findById(id);
		if(opt.isEmpty()) {
			throw new StudentNotFound("Student not Found with this "+ id);
		}
		
		return opt.get();
		
	}

	@Override
	public Student getStudentbyname(String name) {
		// TODO Auto-generated method stub
		Student student = studentdao.findByName(name);
		if(student==null) {
			throw new StudentNotFound("student not exist");
		}
		return null;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentdao.findById(student.getCode());
		
		if(opt.isPresent()) {
			studentdao.delete(opt.get());
			return true;
		}
		
		return false;
	}

	@Override
	public Student updateStudentcourse(Student student, Course course) {
		// TODO Auto-generated method stub
		student.getCourses().add(course);
		
		return student;
	}

	@Override
	public List<Student> getallStudentbyCourse(String coursename) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		List<Student> allstudent = studentdao.findAll();
		for(Student s: allstudent) {
			for(Course c: s.getCourses()) {
				if(c.getName().equals(coursename)) {
					students.add(s);
				}
			}
		}
		if(students==null) {
			throw new StudentNotFound("Student Not found from this course");
		}
		return students;
	}

}
