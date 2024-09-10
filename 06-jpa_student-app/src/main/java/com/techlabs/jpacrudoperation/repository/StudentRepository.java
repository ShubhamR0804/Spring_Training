package com.techlabs.jpacrudoperation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.jpacrudoperation.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByName(String name);
	List<Student> findByRollNumber(int rollNumber);

}
