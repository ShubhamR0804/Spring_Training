package com.techlabs.jpacrudoperation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.jpacrudoperation.entity.Student;
import com.techlabs.jpacrudoperation.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<Page<Student>> getAllStudents(@RequestParam(required = false) String name, @RequestParam int pageSize, @RequestParam int pageNumber){
		if(name!=null)
			return ResponseEntity.ok(studentService.getStudentsByName(name,pageSize,pageNumber));
		return ResponseEntity.ok(studentService.getAllStudents(pageSize,pageNumber));
		
	}
	


}
