package com.techlabs.jpacrudoperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.techlabs.jpacrudoperation.entity.Student;
import com.techlabs.jpacrudoperation.repository.StudentRepository;

public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(int rollNumber) {
		// TODO Auto-generated method stub
		return studentRepository.findById(rollNumber);
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
/*
	@Override
	public List<Student> getStudentsByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findAll(name);
	}
*/
}
