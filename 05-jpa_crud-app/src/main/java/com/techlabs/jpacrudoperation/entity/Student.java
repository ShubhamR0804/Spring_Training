package com.techlabs.jpacrudoperation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
	
	@Column(name="rollNumber")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int rollnumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	
	
}
