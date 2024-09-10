package com.techlabs.jpacrudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.jpacrudoperation.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
