package com.portfolio.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portfolio.dto.SendMessageDTO;
import com.portfolio.model.HireMessage;

@Service
public class MessageService {
	
	final JavaMailSender javaMail;

	MessageService(JavaMailSender javaMail) {
		this.javaMail = javaMail;
	}
	
	public String sendMessageDetails(SendMessageDTO sendMessage) {
		 HireMessage hire = new HireMessage();
		 hire.setName(sendMessage.getName());
		 hire.setEmail(sendMessage.getEmail());
		 hire.setSubject(sendMessage.getSubject());
		 hire.setMessage(sendMessage.getMessage());
		 SimpleMailMessage mail = new SimpleMailMessage();
		  mail.setFrom("manikumar052002@gmail.com");
		  mail.setSubject(hire.getSubject());
		  mail.setTo("manikumar200205@gmail.com");
		  mail.setText(
				    "Hello Mani,\n\n" + 
				    "You have received a new message through your portfolio website.\n\n" +
				    "Contact Details:\n" +
				    "-------------------------\n" +
				    "Name    : " + hire.getName() + "\n" +
				    "Email   : " + hire.getEmail() + "\n" +
				    "Subject : " + hire.getSubject() + "\n\n" + 
				    "Message:\n" +
				    hire.getMessage() + "\n\n" +
				    "Please review the message and respond accordingly.\n\n" +
				    "Best Regards,\n" +
				    "Portfolio Website Notification System"
				);
				javaMail.send(mail);
		     return "Thank you for reaching out! Your message has been received successfully. I'll get back to you as soon as possible.\r\n";	 
	}
	
}
