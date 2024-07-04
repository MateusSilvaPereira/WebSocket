package com.msp.chat.model;

import lombok.Data;

@Data
public class ChatMessage {
	private String from;
	private String content;
}