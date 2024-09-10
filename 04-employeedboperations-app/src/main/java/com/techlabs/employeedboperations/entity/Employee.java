package com.techlabs.employeedboperations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	@Column(name="employeeId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empid;
	@Column(name="employeeName")
	private String empname;
	@Column(name="employeeDepartment")
	private String department;
	public Employee(String empname, String department) {
		super();
		this.empname = empname;
		this.department = department;
	}
	public Employee() {
		super();
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}
