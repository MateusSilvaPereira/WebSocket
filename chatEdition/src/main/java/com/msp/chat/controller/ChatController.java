package com.msp.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.msp.chat.model.ChatMessage;
import com.msp.chat.model.ChatMessageEntity;
import com.msp.chat.repository.ChatMessageRepository;

@Controller
public class ChatController {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	private ChatMessageRepository repository;

	public ChatController(ChatMessageRepository repository) {
		this.repository = repository;
	}

	// Este Método é responsável por responder as mensagens recebida em "/enviarMensage" via WebSocket
	// e envia uma resposta para "/topic/messages"
	@MessageMapping("/enviarMensage")
	@SendTo("/topic/messages")
	public ChatMessage sendMessage(ChatMessage message) {
		String content = message.getContent();
		ChatMessageEntity entity = new ChatMessageEntity();
		entity.setSender(message.getFrom());
		entity.setContent(message.getContent());
		repository.save(entity);
		logger.info("Mensagem recebida: {}", content);
		return message;
	}

}
