package com.techlabs.mapping.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.mapping.dto.PageResponseDto;
import com.techlabs.mapping.entity.Address;
import com.techlabs.mapping.entity.Student;
import com.techlabs.mapping.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		logger.info("Student added successfully" + student.getName());
		return studentRepository.save(student);
	}

	@Override
	public PageResponseDto getAllStudents(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);

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
	public Address getStudentAddressByRollNumber(int id) {
		// TODO Auto-generated method stub
		Address address = null;
		Optional<Student> student = studentRepository.findById(id);
		if (student.isEmpty()) {
			logger.error("Student not present");
			return null;
		}
		address = student.get().getAddress();
		return address;
	}

	@Override
	public Address updateStudentAddress(int rollNumber, Address address) {
		// TODO Auto-generated method stub

		Student studentdb = null;
		Optional<Student> optionalStudent = studentRepository.findById(rollNumber);
		if (!optionalStudent.isPresent())
			return null;
		studentdb = optionalStudent.get();
		Address addressdb = studentdb.getAddress();
		addressdb.setCity(addressdb.getCity());
		studentdb.setAddress(addressdb);
		return studentRepository.save(studentdb).getAddress();
	}

}
