package com.techlabs.mapping.service;

import java.util.List;

import com.techlabs.mapping.dto.InstructorDto;
import com.techlabs.mapping.entity.Instructor;

public interface InstructorService {
	
	InstructorDto addInstructor(InstructorDto instructorDto);
	public InstructorDto getInstructorbyId (int instructorId);
	List<InstructorDto> getAllInstructors();
	Instructor allocateCourses(int instructorId, List<Integer> courseIds);
}
