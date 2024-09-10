package com.techlabs.jpacrudoperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.jpacrudoperation.dto.PageResponseDto;
import com.techlabs.jpacrudoperation.entity.Student;
import com.techlabs.jpacrudoperation.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public PageResponseDto getAllStudents(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		
		Pageable pageable =PageRequest.of(pageNumber, pageSize);
		
		Page<Student> studentPage = studentRepository.findAll(pageable);
		PageResponseDto studentPageDto = new PageResponseDto();
		studentPageDto.setTotalPages(studentPage.getTotalPages());
		studentPageDto.setTotalElements(studentPage.getTotalElements());
		studentPageDto.setSize(studentPage.getSize());
		studentPageDto.setContent(studentPage.getContent());
		studentPageDto.setLastPage(studentPage.isLast());
		
		return studentPageDto;
	}

	@Override
	public PageResponseDto getStudentsByName(String name, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable =PageRequest.of(pageNumber, pageSize);
		Page<Student> studentPage = studentRepository.findByName(name, pageable);
		PageResponseDto studentPageDto = new PageResponseDto();
		studentPageDto.setTotalPages(studentPage.getTotalPages());
		studentPageDto.setTotalElements(studentPage.getTotalElements());
		studentPageDto.setSize(studentPage.getSize());
		studentPageDto.setContent(studentPage.getContent());
		
		return studentPageDto;
		
	}


}
