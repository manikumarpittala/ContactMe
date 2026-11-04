package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portfolio.dao.MessageRepository;
import com.portfolio.dto.SendMessageDTO;
import com.portfolio.model.HireMessage;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MessageService {

	final MessageRepository messageRepository;

	MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	@Autowired
	JavaMailSender javaMail;
	
	public String sendMessageDetails(SendMessageDTO sendMessage) {
		 HireMessage hire = new HireMessage();
		 hire.setName(sendMessage.getName());
		 hire.setEmail(sendMessage.getEmail());
		 hire.setSubject(sendMessage.getSubject());
		 hire.setMessage(sendMessage.getMessage());
		 HireMessage saved = messageRepository.save(hire);
		 if(saved != null) {
		 SimpleMailMessage mail = new SimpleMailMessage();
		  mail.setFrom("manikumar052002@gmail.com");
		  mail.setSubject(saved.getSubject());
		  mail.setTo("manikumar200205@gmail.com");
		  mail.setText(
				    "Hello Mani,\n\n" + 
				    "You have received a new message through your portfolio website.\n\n" +
				    "Contact Details:\n" +
				    "-------------------------\n" +
				    "Name    : " + saved.getName() + "\n" +
				    "Email   : " + saved.getEmail() + "\n" +
				    "Subject : " + saved.getSubject() + "\n\n" + 
				    "Message:\n" +
				    saved.getMessage() + "\n\n" +
				    "Please review the message and respond accordingly.\n\n" +
				    "Best Regards,\n" +
				    "Portfolio Website Notification System"
				);
				javaMail.send(mail);
		     return "Thank you for reaching out! Your message has been received successfully. I'll get back to you as soon as possible.\r\n";  
		  } else {
			  return "Oops! Something went wrong while sending your message. Please try again later.\r\n";
		  }
		 
	}
	
}
