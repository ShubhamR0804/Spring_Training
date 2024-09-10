package com.techlabs.mapping.service;

import java.util.List;

import com.techlabs.mapping.dto.CourseDto;
import com.techlabs.mapping.entity.Course;
import com.techlabs.mapping.entity.Instructor;
import com.techlabs.mapping.entity.Student;

public interface CourseService {

	
	Course addCourse(CourseDto courseDto);
	
	Course allocateInstructor(int courseId, Instructor instructor);
	
	CourseDto getCourseById(int courseId);

	CourseDto assignInstructor(int courseId, int instructorId);

	CourseDto assignStudents(int courseIds, List<Integer> rollNumber);
}
