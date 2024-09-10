package com.techlabs.email.service;

import com.techlabs.email.entity.EmailDetails;

public interface EmailService {
	
	String sendMailWithAttachment(EmailDetails details);

}
