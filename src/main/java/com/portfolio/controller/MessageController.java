package com.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.SendMessageDTO;
import com.portfolio.service.MessageService;

@RestController
@RequestMapping("/contact")
public class MessageController {

	final MessageService messageService;

	MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
		
	@PostMapping("/send")
	@ResponseStatus(HttpStatus.OK)
	public String sendMessageDetails(@RequestBody SendMessageDTO sendMessage) {
		return messageService.sendMessageDetails(sendMessage);
	}
	
}
	
