package com.techlabs.mapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mapping.dto.InstructorDto;
import com.techlabs.mapping.entity.Course;
import com.techlabs.mapping.entity.Instructor;
import com.techlabs.mapping.repository.CourseRepository;
import com.techlabs.mapping.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	 private InstructorRepository instructorRepo;
	
	@Autowired
	private CourseRepository courseRepo;

	 @Override
	 public InstructorDto addInstructor(InstructorDto instructorDto) {
	  Instructor instructor = toInstructorMapper(instructorDto);
	  return toInstructorDtoMapper(instructor);

	 }
	 
	 public InstructorDto toInstructorDtoMapper (Instructor instructor) {
	  InstructorDto instructorDto = new InstructorDto();
	  instructorDto.setInstructorId(instructor.getInstructorId());
	  instructorDto.setName(instructor.getName());
	  instructorDto.setEmail(instructor.getEmail());
	  instructorDto.setQualification(instructor.getQualification());
	  return instructorDto;
	  
	 }
	 
	 public Instructor toInstructorMapper(InstructorDto instructorDto) {
	  Instructor instructor = new Instructor();
	  instructor.setInstructorId(instructorDto.getInstructorId());
	  instructor.setName(instructorDto.getName());
	  instructor.setEmail(instructorDto.getEmail());
	  instructor.setQualification(instructorDto.getQualification());
	  instructor = instructorRepo.save(instructor);
	  return instructor;
	 }

	@Override
	public InstructorDto getInstructorbyId(int instructorId) {
		// TODO Auto-generated method stub
		Optional<Instructor> optionalInstructor = instructorRepo.findById(instructorId);
		if (!optionalInstructor.isPresent())
			return null;
		Instructor dbinstructor = optionalInstructor.get();
		System.out.println(toInstructorDtoMapper(dbinstructor));
		return toInstructorDtoMapper(dbinstructor);
	}

	@Override
	public List<InstructorDto> getAllInstructors() {
		// TODO Auto-generated method stub
		List<Instructor> instructors = instructorRepo.findAll();
		List<InstructorDto> instructorDtos = new ArrayList<>(); 
		System.out.println("ddvwvwjnv");
		for (Instructor instructor : instructors) {		
			InstructorDto dto = toInstructorDtoMapper(instructor);
			System.out.println("sxqccceq");
			instructorDtos.add(dto); 
		}

		return instructorDtos;
	}

	@Override
	public Instructor allocateCourses(int instructorId, List<Integer> courseIds) {
		// TODO Auto-generated method stub
		
		Instructor dbInstructor = toInstructorMapper(getInstructorbyId(instructorId));
		dbInstructor.setInstructorId(instructorId);
		List<Course> dbCourses=dbInstructor.getCourses();
		if(dbCourses==null)
			dbCourses=new ArrayList<>();
		List<Course> coursesToadd=new ArrayList<>();
		courseIds.forEach((courseId)->{
			Optional<Course> optionalCourse=courseRepo.findById(courseId);
			if(!optionalCourse.isPresent())
				throw new NullPointerException("Course does not Exist");
			Course course=optionalCourse.get();
			course.setInstructor(dbInstructor);
			coursesToadd.add(course);
		});
		
		dbCourses.addAll(coursesToadd);
		dbInstructor.setCourses(dbCourses);	
			
		return instructorRepo.save(dbInstructor);
	}
	

}
