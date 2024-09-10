package com.techlabs.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.mapping.dto.InstructorDto;
import com.techlabs.mapping.entity.Instructor;
import com.techlabs.mapping.service.InstructorService;


@RequestMapping("/studentapp")
@RestController
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;

	@PostMapping("/instructors")
	public ResponseEntity<InstructorDto> addNewInstructor(@RequestBody InstructorDto instructordto) {
		InstructorDto createdInstructor = instructorService.addInstructor(instructordto);
		return ResponseEntity.ok(createdInstructor);
	}

	@GetMapping("/instructors/{instructorid}")
	public ResponseEntity<InstructorDto> getInstructor(@PathVariable int instructorId) {
		return ResponseEntity.ok(instructorService.getInstructorbyId(instructorId));
	}
	
	@GetMapping("/instructors")
    public ResponseEntity<List<InstructorDto>> getAllInstructors() {
        List<InstructorDto> instructors = instructorService.getAllInstructors();
        if (instructors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(instructors, HttpStatus.OK);}

	@PutMapping("instructors/courses")
	public ResponseEntity<Instructor> allocateCourses(@RequestParam int instructorId, @RequestBody List<Integer> courseIds) {
		//TODO: process PUT request
		
		return ResponseEntity.ok(instructorService.allocateCourses(instructorId,courseIds));
	}
}
