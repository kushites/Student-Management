package com.studentmanagement.exceptions;

import java.time.LocalDateTime;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.studentmanagement.entity.Student;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<MyErrorDetails> StudentNotFoundException(StudentNotFound snf, WebRequest wr){
		MyErrorDetails mrd = new MyErrorDetails(LocalDateTime.now(), snf.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(mrd, HttpStatus.BAD_REQUEST);
	}	
	
}
