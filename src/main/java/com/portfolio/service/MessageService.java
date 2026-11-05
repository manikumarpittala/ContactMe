package com.portfolio.service;

import org.springframework.stereotype.Service;

import com.portfolio.dto.SendMessageDTO;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;

@Service
public class MessageService {
	
	private final Resend resend;

	public MessageService(Resend resend) {
	    this.resend = resend;
	}
	
	public String sendMessageDetails(SendMessageDTO sendMessage) {
            CreateEmailOptions params = CreateEmailOptions.builder()
	            .from("Portfolio <onboarding@resend.dev>")
	            .to("manikumar052002@gmail.com")
	            .subject(sendMessage.getSubject())
	            .replyTo(sendMessage.getEmail())
	            .text(
	                "Hello Mani,\n\n" +
	                "You have received a new message through your portfolio website.\n\n" +
	                "Contact Details:\n" +
	                "Name: " + sendMessage.getName() + "\n" +
	                "Email: " + sendMessage.getEmail() + "\n" +
	                "Subject: " + sendMessage.getSubject() + "\n\n" +
	                "Message:\n" + sendMessage.getMessage()
	            )
	            .build();

		    try {
		    	resend.emails().send(params);
				return "Thank you for reaching out! Your message has been received successfully. I'll get back to you as soon as possible.";
			} catch (ResendException e) {
				e.printStackTrace();
				return "Something went wrong";
			}

	}
	
}
