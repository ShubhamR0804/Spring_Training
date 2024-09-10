package com.techlabs.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.techlabs.email.service.EmailSenderService;

@SpringBootApplication
public class Application {
 
	@Autowired
	private EmailSenderService emailSenderService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() {
		emailSenderService.sendEmail("swap.kal20@gmail.com", "Sending an email with attatchment from a Spring Boot application", "POC on sending mail through spring completed", "D:\\rating.webp");
	}

}
