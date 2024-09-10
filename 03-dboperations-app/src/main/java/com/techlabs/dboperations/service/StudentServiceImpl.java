package com.techlabs.dboperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.dboperations.entity.Student;
import com.techlabs.dboperations.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepo.getAllStudents();
	}

	@Override
	public Student getStudent(int rollNumber) {
		return studentRepo.getStudent(rollNumber);
	}

	@Override
	public void addStudent(Student student) {
		studentRepo.addStudent(student);
		
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		// TODO Auto-generated method stub
		return studentRepo.getStudentsByName(name);
	}
	
	
	

}
