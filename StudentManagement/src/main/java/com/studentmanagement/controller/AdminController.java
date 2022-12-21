package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.studentmanagement.service.CourseService;
import com.studentmanagement.service.Studentservice;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private Studentservice studentservice;
	
	@Autowired
	private CourseService courseservice;
	
	@PostMapping("/savestudent")
	public ResponseEntity<Student> savetheStudent(@RequestBody Student student){
		Student stu = studentservice.saveStudent(student);
		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
	}
	
	@PostMapping("/savecourse")
	public ResponseEntity<Course> savetheCourse(@RequestBody Course course){
		Course cou = courseservice.saveCourse(course);
		return new ResponseEntity<Course>(cou, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatestudentcourse")
	public ResponseEntity<Student> updatetheStudentCourse(@RequestBody Student student, Course course){
		Student stu = studentservice.updateStudentcourse(student, course);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}
	
	@GetMapping("/getstudentbycourse/{coursename}")
	public ResponseEntity<List<Student>> getStudentbyCourse(@PathVariable String coursename){
		List<Student> stulist = studentservice.getallStudentbyCourse(coursename);
		return new ResponseEntity<List<Student>>(stulist, HttpStatus.OK);
	}
	
	@GetMapping("/getstudentbyname/{name}")
	public ResponseEntity<Student> getstudentbytheName(@PathVariable String name){
		Student stu = studentservice.getStudentbyname(name);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}
	
	
}
