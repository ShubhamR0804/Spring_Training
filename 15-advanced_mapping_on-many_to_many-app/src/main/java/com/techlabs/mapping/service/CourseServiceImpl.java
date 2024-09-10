package com.techlabs.mapping.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mapping.dto.CourseDto;
import com.techlabs.mapping.entity.Course;
import com.techlabs.mapping.entity.Instructor;
import com.techlabs.mapping.entity.Student;
import com.techlabs.mapping.repository.CourseRepository;
import com.techlabs.mapping.repository.InstructorRepository;
import com.techlabs.mapping.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private InstructorRepository instructorRepo;

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Course addCourse(CourseDto courseDto) {
		// TODO Auto-generated method stub
		Course course = new Course();
		course.setName(courseDto.getName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		return courseRepo.save(course);
	}

	@Override
	public Course allocateInstructor(int courseId, Instructor instructor) {
		// TODO Auto-generated method stub
		Optional<Course> courseOptional = courseRepo.findById(courseId);
		if (!courseOptional.isPresent())
			return null;

		Course dbCourse = courseOptional.get();

		Instructor dbInstructor;
		Optional<Instructor> instructoroptional = instructorRepo.findById(instructor.getInstructorId());
		if (!instructoroptional.isPresent())
			return null;

		dbInstructor = instructoroptional.get();

		dbCourse.setInstructor(dbInstructor);

		return courseRepo.save(dbCourse);
	}

	@Override
	public CourseDto getCourseById(int courseId) {
		// TODO Auto-generated method stub
		Course course = null;

		Optional<Course> optionalCourse = courseRepo.findById(courseId);
		if (!optionalCourse.isPresent())
			return null;

		course = optionalCourse.get();
		return toCourseDtoMapper(course);
	}

	private CourseDto toCourseDtoMapper(Course course) {
		// TODO Auto-generated method stub
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseID(course.getCourseId());
		courseDto.setName(course.getName());
		courseDto.setDuration(course.getDuration());
		courseDto.setFees(course.getFees());
		return courseDto;
	}

	public Course toCourseMapper(CourseDto courseDto) {
		Course course = new Course();
		course.setName(courseDto.getName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		course = courseRepo.save(course);
		return course;

	}

	@Override
	public CourseDto assignInstructor(int courseId, int instructorId) {
		// TODO Auto-generated method stub

		Course dbCourse = toCourseMapper(getCourseById(courseId));
		dbCourse.setCourseId(courseId);

		Instructor optionalInstructor = instructorRepo.findById(instructorId)
				.orElseThrow(() -> new NullPointerException("Instructor not found"));

		dbCourse.setInstructor(optionalInstructor);
		dbCourse = courseRepo.save(dbCourse);

		return toCourseDtoMapper(dbCourse);
	}

	@Override
	public CourseDto assignStudents(int courseIds, List<Integer> rollNumber) {
		// TODO Auto-generated method stub
		Course dbCourse = courseRepo.findById(courseIds)
				.orElseThrow(() -> new NullPointerException("Course not found"));
		List<Student> existingStudents = dbCourse.getStudents();

		if (existingStudents == null)
			existingStudents = new ArrayList<>();

		List<Student> studentsToAdd = new ArrayList<>();
		rollNumber.forEach((id) -> {
			Student student = studentRepository.findById(id)
					.orElseThrow(() -> new NullPointerException("Student not Found"));
			Set<Course> courses = student.getCourses();
			if (courses == null)
				courses = new HashSet<>();
			courses.add(dbCourse);
			student.setCourses(courses);
			studentsToAdd.add(student);

		});

		existingStudents.addAll(studentsToAdd);
		dbCourse.setStudents(existingStudents);
		// student = studentRepository.save(student);
		return toCourseDtoMapper(courseRepo.save(dbCourse));
	}
}
