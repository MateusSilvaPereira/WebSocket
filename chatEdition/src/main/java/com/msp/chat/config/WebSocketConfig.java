package com.msp.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	// Este Método é responsável por configurar o broker de mensagens para o WebSocket.
	// Está configuração é para habilitar um broker simples com o prefixo "/topic".
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	// Este Método é responsável por registrar os endpoints do Stomp WebSocket.
	// Registro do endpoint "/ws" que suporta conexões com origem permitida para "http://localhost:3000".
	// Protocolo SockJS para a compatibilidade com navegadores que não suportam WebSocket diretamente.
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").setAllowedOriginPatterns("http://localhost:3000").withSockJS();
	}
}
