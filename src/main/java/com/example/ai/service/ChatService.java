package com.example.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.example.ai.advistor.TokenUsageLogAdvistor;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ChatService {
	private final ChatClient chatClient;
	
	public String chat(String chatId, String userMessage) {	   	
		return this.chatClient.prompt()
		.advisors(new TokenUsageLogAdvistor())
		.user(userMessage)
        .call().content();
	}
}
