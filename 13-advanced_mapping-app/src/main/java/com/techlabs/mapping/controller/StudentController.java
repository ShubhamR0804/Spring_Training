package com.techlabs.mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.mapping.dto.PageResponseDto;
import com.techlabs.mapping.entity.Address;
import com.techlabs.mapping.entity.Student;
import com.techlabs.mapping.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/students")
	public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}

	@GetMapping("/students")
	public ResponseEntity<PageResponseDto> getAllStudents(@RequestParam int pageSize, @RequestParam int pageNumber) {
		return ResponseEntity.ok(studentService.getAllStudents(pageSize, pageNumber));

	}
	
	@GetMapping("/address/{rollNumber}")
	public ResponseEntity<Address> getStudentsAddressByRollNumber(@PathVariable int rollNumber)
	{
		return ResponseEntity.ok(studentService.getStudentAddressByRollNumber(rollNumber));
	}
	
	@PutMapping("/students/address")
	public ResponseEntity<Address> addNewStudent(@RequestBody Address address, @RequestParam int rollNumber) {
		return ResponseEntity.ok(studentService.updateStudentAddress(rollNumber, address));
	}
}
