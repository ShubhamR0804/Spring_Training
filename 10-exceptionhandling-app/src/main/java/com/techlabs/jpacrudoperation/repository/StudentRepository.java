package com.techlabs.jpacrudoperation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.jpacrudoperation.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Page<Student> findByName(String name, Pageable pageable);
}
