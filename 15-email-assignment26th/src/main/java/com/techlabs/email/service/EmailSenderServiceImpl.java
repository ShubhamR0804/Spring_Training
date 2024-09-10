package com.techlabs.email.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(String toEmail, String body, String subject, String attatchment) {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom("shubhamramteke0000@gmail.com");
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setText(body);
			mimeMessageHelper.setSubject(subject);
			
			FileSystemResource fileSystemResource = new FileSystemResource(new File(attatchment));
			mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
			javaMailSender.send(mimeMessage);
			
			System.out.println("Mail sent successfully");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
