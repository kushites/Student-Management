package com.studentmanagement.entity;


import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	private String name;
	private LocalDateTime dob;
	private String gender;
	private String parentsname;
	private long mobileno;
	private String email;
	
	
	@ManyToMany
	private List<Course> courses;
	@OneToMany
	private List<Address> addresses;
	
	
	
	

}
