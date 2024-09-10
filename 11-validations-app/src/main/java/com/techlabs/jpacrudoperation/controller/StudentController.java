package com.techlabs.jpacrudoperation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.jpacrudoperation.dto.PageResponseDto;
import com.techlabs.jpacrudoperation.entity.Student;
import com.techlabs.jpacrudoperation.errors.StudentErrorResponse;
import com.techlabs.jpacrudoperation.exception.StudentDoesNotExistException;
import com.techlabs.jpacrudoperation.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<PageResponseDto> getAllStudents(@RequestParam(required = false) String name, @RequestParam int pageSize, @RequestParam int pageNumber){
		if(name!=null)
			return ResponseEntity.ok(studentService.getStudentsByName(name,pageSize,pageNumber));
		return ResponseEntity.ok(studentService.getAllStudents(pageSize,pageNumber));
		
	}
	
	@GetMapping("/students/{rollNumber}")
	public ResponseEntity<Student> getAllStudents(@PathVariable int rollNumber)
	{
		return ResponseEntity.ok(studentService.getStudentByRollNumber(rollNumber));
		
	}
/*	
	@ExceptionHandler
	public ResponseEntity handlesStudentDoesNotExistException(StudentDoesNotExistException exception)
	{
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(exception.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
*/

}
