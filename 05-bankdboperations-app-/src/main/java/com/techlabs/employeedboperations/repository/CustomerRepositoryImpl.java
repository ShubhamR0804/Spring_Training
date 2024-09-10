package com.techlabs.employeedboperations.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.employeedboperations.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	 @Autowired 
	 private EntityManager manager; 
	 
	 @Override 
	 public List<Customer> getAllCustomer() { 
	  TypedQuery<Customer> query = manager.createQuery("select c from Customer c", Customer.class); 
	  return query.getResultList(); 
	 } 
	 
	 @Override 
	 public Customer getCustomer(int customerid) { 
	   return manager.find(Customer.class,customerid); 
	 } 
	 
	 @Override 
	  public Customer insertCustomer(Customer customer) { 
	        manager.persist(customer); 
	        return customer; 
	    } 
	 
	 @Override 
	  public Customer updateCustomer(Customer customer) { 
	        return manager.merge(customer); 
	    } 


}
