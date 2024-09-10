package com.techlabs.dboperations.repository;

import java.util.List;

import com.techlabs.dboperations.entity.Student;

public interface StudentRepository {

	List<Student> getAllStudents();
	Student getStudent(int rollNumber);
	void addStudent(Student student);
	List<Student> getStudentsByName(String name);
}
