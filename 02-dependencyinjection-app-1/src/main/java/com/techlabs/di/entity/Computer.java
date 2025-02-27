package com.techlabs.di.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Computer {
	@Value("apple")
	private String name;
	private Harddisk harddisk;
	@Autowired
	public Computer(String name, Harddisk harddisk) {
		super();
		this.name = name;
		this.harddisk = harddisk;
	}
	@Override
	public String toString() {
		return "Computer [name=" + name + ", harddisk=" + harddisk + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Harddisk getHarddisk() {
		return harddisk;
	}
	public void setHarddisk(Harddisk harddisk) {
		this.harddisk = harddisk;
	}
	public Computer() {
		super();
	}
	
	
	
}