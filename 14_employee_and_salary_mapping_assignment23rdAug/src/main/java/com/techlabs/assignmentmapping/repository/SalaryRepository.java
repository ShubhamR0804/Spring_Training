package com.techlabs.assignmentmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.assignmentmapping.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer>{

}
