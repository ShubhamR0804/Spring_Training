package com.techlabs.intro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello!! This is a spring starter project";
	}
	
	@GetMapping("/bye")
	public String tataBye() {
		return "This has ended, Bye";
	}

}
