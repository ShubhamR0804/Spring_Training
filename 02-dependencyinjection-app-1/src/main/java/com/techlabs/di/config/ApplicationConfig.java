package com.techlabs.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techlabs.di.entity.Computer;
import com.techlabs.di.entity.Harddisk;

@Configuration
public class ApplicationConfig {
	@Bean
	Computer getComputer() {
		return new Computer();
	}
	
	@Bean
	Harddisk getHarddisk() {
		return new Harddisk();
	}

}
