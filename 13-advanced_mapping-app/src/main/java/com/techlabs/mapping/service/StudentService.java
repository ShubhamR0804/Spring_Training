package com.techlabs.mapping.service;

import com.techlabs.mapping.dto.PageResponseDto;
import com.techlabs.mapping.entity.Address;
import com.techlabs.mapping.entity.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	PageResponseDto getAllStudents(int pageSize, int pageNumber);
	Address getStudentAddressByRollNumber(int id);
	Address updateStudentAddress(int rollNumber, Address address);

}
