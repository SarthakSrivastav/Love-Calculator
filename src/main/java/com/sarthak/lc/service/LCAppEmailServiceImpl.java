package com.sarthak.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String userName, String to, String result) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject("Love Calculator Application Result.");
		simpleMailMessage.setText("Hi " + userName + ",\nThe result predicted by the Love Calculator is " + result);
		javaMailSender.send(simpleMailMessage);
		
		System.out.println("Email Message Sent Successfully");

	}

}
