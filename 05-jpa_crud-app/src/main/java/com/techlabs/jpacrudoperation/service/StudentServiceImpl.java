package com.techlabs.jpacrudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.jpacrudoperation.entity.Student;
import com.techlabs.jpacrudoperation.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		return studentRepository.findAll();
	}
	

}
