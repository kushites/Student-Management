package com.studentmanagement.exceptions;

public class CourseNotFound extends RuntimeException{
	
	public CourseNotFound(String msg) {
		super(msg);
	}

}
