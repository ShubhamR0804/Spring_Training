package com.techlabs.dboperations.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.dboperations.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> query = manager.createQuery("select s from Student s",Student.class);
		return query.getResultList();
	}

	@Override
	public Student getStudent(int rollNumber) {
		return manager.find(Student.class, rollNumber);
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		manager.persist(student);
		
	}
	
	
	@Override
	public List<Student> getStudentsByName(String name) {
		TypedQuery<Student> query = manager.createQuery("select s from Student s where s.name=:theName",Student.class);
		query.setParameter("theName", name);
		return query.getResultList();
	}
	

}
