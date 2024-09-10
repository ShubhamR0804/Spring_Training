package com.techlabs.jpacrudoperation.service;

import java.util.List;
import java.util.Optional;

import com.techlabs.jpacrudoperation.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Optional<Student> getStudent(int rollNumber);
	Student addStudent(Student student);
	//List<Student> getStudentsByName(String name);

}
