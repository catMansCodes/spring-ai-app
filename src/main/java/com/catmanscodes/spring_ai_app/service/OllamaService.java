package com.catmanscodes.spring_ai_app.service;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaService implements AIService {

    private final ChatClient chatClient;

    public OllamaService(OllamaChatModel model) {

        this.chatClient = ChatClient.create(model);
    }

    @Override
    public String chat(String message) {

        return chatClient.prompt().user(message).call().content();
    }
}