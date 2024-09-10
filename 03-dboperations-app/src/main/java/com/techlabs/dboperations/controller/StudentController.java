package com.techlabs.dboperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.dboperations.entity.Student;
import com.techlabs.dboperations.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/studentsapp")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	 @GetMapping("/students/{rollnumber}")
	 public ResponseEntity<Student> getStudent(@PathVariable int rollnumber){
	  return ResponseEntity.ok(studentService.getStudent(rollnumber));
	  
	 }
	 @GetMapping("/studentsname")
	 public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name){
		 return ResponseEntity.ok(studentService.getStudentsByName(name));
	 }
	 
	 @PostMapping("/students")
	 public String addStudent(@RequestBody Student student) {
	  studentService.addStudent(student);
	  return "Student added successfully";
	 }
	

}
