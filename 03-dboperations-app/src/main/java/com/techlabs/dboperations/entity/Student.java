package com.techlabs.dboperations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Column(name="rollNumber")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	
	private int rollnumber;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	public Student(String name, int age) {
		super();
		
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
