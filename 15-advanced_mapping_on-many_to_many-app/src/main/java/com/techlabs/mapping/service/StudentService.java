package com.techlabs.mapping.service;

import java.util.List;

import com.techlabs.mapping.dto.PageResponseDto;
import com.techlabs.mapping.dto.StudentDto;
import com.techlabs.mapping.entity.Address;
import com.techlabs.mapping.entity.Course;
import com.techlabs.mapping.entity.Student;

public interface StudentService {
	
	StudentDto addStudent(Student student);
	PageResponseDto getAllStudents(int pageSize, int pageNumber);
	Address getStudentAddressByRollNumber(int id);
	Address updateStudentAddress(int rollNumber, Address address);
	
	StudentDto getStudentByRollNumber(int rollNumber);
	PageResponseDto<StudentDto> getAllStudent(int pageSize, int pageNumber);
    StudentDto assignCourses(int rollNumber, List<Integer> courseIds);

}
