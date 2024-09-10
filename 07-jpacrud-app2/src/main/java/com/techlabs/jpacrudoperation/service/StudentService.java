package com.techlabs.jpacrudoperation.service;

import org.springframework.data.domain.Page;

import com.techlabs.jpacrudoperation.entity.Student;

public interface StudentService {
	
	Page<Student> getAllStudents(int pageSize, int pageNumber);
	Page<Student> getStudentsByName(String name,int pageSize,int pageNumber);
}
