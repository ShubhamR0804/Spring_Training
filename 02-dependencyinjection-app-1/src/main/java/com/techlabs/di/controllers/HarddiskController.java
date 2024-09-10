package com.techlabs.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.di.entity.Harddisk;

@RestController
public class HarddiskController {
	
	@Autowired
	private Harddisk harddisk; 
	
	@GetMapping("/harddisk")
	private Harddisk getHarddisk() {
		return harddisk;
	}

}
