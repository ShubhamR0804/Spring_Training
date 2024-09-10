package com.techlabs.jpacrudoperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.jpacrudoperation.entity.Student;
import com.techlabs.jpacrudoperation.service.StudentService;

@RestController
@RequestMapping("/studentsapp")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
		
	}
	
	@GetMapping("/students/{rollnumber}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable int rollnumber){
		return ResponseEntity.ok(studentService.getStudent(rollnumber));
		
	}
	
	@GetMapping("/studentsname")
	public 
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student added successfully";
	}
	

}
