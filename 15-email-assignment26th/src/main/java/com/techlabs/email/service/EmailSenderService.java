package com.techlabs.email.service;

public interface EmailSenderService {
	
	void sendEmail(String toEmail, String body, String subject, String attatchment);

}
