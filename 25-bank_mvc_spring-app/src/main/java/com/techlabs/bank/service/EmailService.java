package com.techlabs.bank.service;

import com.techlabs.bank.entity.EmailDetails;

public interface EmailService {

String sendSimpleEmail(EmailDetails deatils);
	
	String sendMailWithAttachments(EmailDetails details);
}
