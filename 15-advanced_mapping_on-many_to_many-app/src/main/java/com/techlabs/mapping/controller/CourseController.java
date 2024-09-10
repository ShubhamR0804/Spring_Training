package com.techlabs.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.mapping.dto.CourseDto;
import com.techlabs.mapping.entity.Course;
import com.techlabs.mapping.entity.Student;
import com.techlabs.mapping.service.CourseService;

@RestController
@RequestMapping("/studentapp")
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@PostMapping("/courses")
	public ResponseEntity<Course> addNewCourse(@RequestBody CourseDto courseDto) {
		return ResponseEntity.ok(courseService.addCourse(courseDto));
	}
	
	@PostMapping("/courses/instructor")
	public ResponseEntity<CourseDto> assignInstructor(@RequestParam int courseId, @RequestParam int instructorId){
		return ResponseEntity.ok(courseService.assignInstructor(courseId,instructorId));
		
	}
	
	@PutMapping("/courses/studets")
	public ResponseEntity<CourseDto> assignStudents(@RequestParam int courseIds, @RequestBody List<Integer> rollNumber){
		return ResponseEntity.ok(courseService.assignStudents(courseIds,rollNumber));
		
	}
	
	

}
