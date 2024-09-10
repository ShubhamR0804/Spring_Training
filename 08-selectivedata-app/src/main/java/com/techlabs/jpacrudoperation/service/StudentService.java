package com.techlabs.jpacrudoperation.service;


import com.techlabs.jpacrudoperation.dto.PageResponseDto;


public interface StudentService {
	
	PageResponseDto getAllStudents(int pageSize, int pageNumber);
	PageResponseDto getStudentsByName(String name,int pageSize,int pageNumber);
}
