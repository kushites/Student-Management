package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.entity.Course;
import com.studentmanagement.entity.Student;
import com.studentmanagement.service.Studentservice;


@RestController
@RequestMapping("/user")
public class StudentController {

	@Autowired
	private Studentservice studentservice;
	
	@PutMapping("/updatedetails")
	public ResponseEntity<Student> updateStudentdetails(@RequestBody Student student){
		Student stu = studentservice.updateStudent(student);
		return new ResponseEntity<Student>(stu, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getcourse/{studentname}")
	public ResponseEntity<List<Course>> getallCourseofStudent(@PathVariable String studentname){
		List<Course> courselist = studentservice.getCourses(studentname);
		return new ResponseEntity<List<Course>>(courselist, HttpStatus.OK);
	}
	@GetMapping("/deletecourse/{studentname}/{coursename}")
	public ResponseEntity<Boolean> deleteCourseofStudent(@PathVariable String studentname, String coursename ){
		Boolean br = studentservice.deleteCourseOfStudent(studentname, coursename);
		return new ResponseEntity<Boolean>(br, HttpStatus.OK);
	}
}
