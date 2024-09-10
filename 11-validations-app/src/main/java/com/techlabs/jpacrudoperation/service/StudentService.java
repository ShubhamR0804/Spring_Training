package com.techlabs.jpacrudoperation.service;


import com.techlabs.jpacrudoperation.dto.PageResponseDto;
import com.techlabs.jpacrudoperation.entity.Student;


public interface StudentService {
	
	PageResponseDto getAllStudents(int pageSize, int pageNumber);
	PageResponseDto getStudentsByName(String name,int pageSize,int pageNumber);
	Student getStudentByRollNumber(int rollNumber);
}
