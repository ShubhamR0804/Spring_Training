package com.techlabs.jpacrudoperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.jpacrudoperation.entity.Student;
import com.techlabs.jpacrudoperation.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Page<Student> getAllStudents(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		
		Pageable pageable =PageRequest.of(pageNumber, pageSize);
		return studentRepository.findAll(pageable);
	}

	@Override
	public Page<Student> getStudentsByName(String name, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable =PageRequest.of(pageNumber, pageSize);
		return studentRepository.findByName(name, pageable);
	}
	

}
