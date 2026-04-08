package com.catmanscodes.spring_ai_app.service;

import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GeminiService implements AIService {

    private final ChatClient chatClient;

    public GeminiService(GoogleGenAiChatModel model) {

        this.chatClient = ChatClient.create(model);
    }

    @Override
    public String chat(String message) {

        return chatClient.prompt().user(message).call().content();
    }
}