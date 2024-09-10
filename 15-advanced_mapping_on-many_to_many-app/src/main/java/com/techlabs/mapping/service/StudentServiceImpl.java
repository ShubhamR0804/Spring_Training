package com.techlabs.mapping.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.mapping.dto.PageResponseDto;
import com.techlabs.mapping.dto.StudentDto;
import com.techlabs.mapping.entity.Address;
import com.techlabs.mapping.entity.Course;
import com.techlabs.mapping.entity.Student;
import com.techlabs.mapping.repository.CourseRepository;
import com.techlabs.mapping.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepo;
	@Override
	public StudentDto addStudent(Student student) {
		// TODO Auto-generated method stub
		return toStudentDtoMapper(studentRepository.save(student));
	}
	
	private StudentDto toStudentDtoMapper(Student student)
	{
		StudentDto dto = new StudentDto();
		dto.setAge(student.getAge());
		dto.setName(student.getName());
		dto.setRollNumber(student.getRollNumber());
		return dto;
	}
	
	private Student toStudentMapper(StudentDto studentDto)
	{
		Student student = new Student();
		student.setAge(studentDto.getAge());
		student.setName(studentDto.getName());
		if(studentDto.getRollNumber()>0)
			student.setRollNumber(studentDto.getRollNumber());
		return student;
		
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
		if(student.isEmpty())
			return null;
		address=student.get().getAddress();	
		return address;
	}


	@Override
	public Address updateStudentAddress(int rollNumber, Address address) {
		// TODO Auto-generated method stub
		
		Student studentdb=null;
		Optional<Student> optionalStudent = studentRepository.findById(rollNumber);
		if(!optionalStudent.isPresent())
			return null;
		studentdb = optionalStudent.get();
		Address addressdb = studentdb.getAddress();
		addressdb.setCity(addressdb.getCity());
		studentdb.setAddress(addressdb);
		return studentRepository.save(studentdb).getAddress();
	}

	@Override
	public StudentDto getStudentByRollNumber(int rollNumber) {
		// TODO Auto-generated method stub
		Optional<Student> optionalStudent = studentRepository.findById(rollNumber);
	    if (!optionalStudent.isPresent()) 
	        return null;
	    
	    return toStudentDtoMapper(optionalStudent.get());
	}

	@Override
	public PageResponseDto<StudentDto> getAllStudent(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> studentPage = studentRepository.findAll(pageable);
		
		List<StudentDto> studentDtos = studentPage.getContent().stream()
		        .map(this::toStudentDtoMapper)
		        .toList();
		
		
		PageResponseDto studentPageDto = new PageResponseDto();
		studentPageDto.setTotalPages(studentPage.getTotalPages());
		studentPageDto.setTotalElements(studentPage.getTotalElements());
		studentPageDto.setSize(studentPage.getSize());
		studentPageDto.setContent(studentPage.getContent());
		studentPageDto.setLastPage(studentPage.isLast());

		return studentPageDto;
	}

	@Override
	public StudentDto assignCourses(int rollNumber, List<Integer> courseIds) {
		// TODO Auto-generated method stub
		
		Student dbStudent=studentRepository.findById(rollNumber).orElseThrow(()->new NullPointerException("Student not found"));
		Set<Course> existingCourses=dbStudent.getCourses();
		
		if(existingCourses==null)
			existingCourses=new HashSet<>();
		
		Set<Course> coursesToAdd=new HashSet<>();
		courseIds.forEach((id)->{
			Course course=courseRepo.findById(id).orElseThrow(()->new NullPointerException("Course not Found"));
		List<Student> students=course.getStudents();
		if(students==null)
			students=new ArrayList<>();
		students.add(dbStudent);
		course.setStudents(students);
		coursesToAdd.add(course);
		
		});
		
		existingCourses.addAll(coursesToAdd);
		dbStudent.setCourses(existingCourses);
		//student = studentRepository.save(student);
		return toStudentDtoMapper(studentRepository.save(dbStudent));
	}



}
