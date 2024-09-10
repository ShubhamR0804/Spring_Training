package com.techlabs.dboperations.service;

import java.util.List;

import com.techlabs.dboperations.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student getStudent(int rollNumber);
	void addStudent(Student student);
	List<Student> getStudentsByName(String name);
	

}
