package com.consulting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.consulting.model.Email;
import com.consulting.properties.AppProperties;

@Service
public class NotificationService {

	@Autowired
	private AppProperties properties;
	
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean dispatchEmail(Email email) {
		
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getOrigin());
			message.setTo(properties.getEmail());
			message.setSubject(email.getSubject());
			message.setText(email.getMessage());
			
			mailsender.send(message);
			return true;
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());

			return false;
		}
		
	}
	
}
