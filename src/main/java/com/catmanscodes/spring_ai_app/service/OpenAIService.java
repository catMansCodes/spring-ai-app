package com.catmanscodes.spring_ai_app.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService implements AIService {

    private final ChatClient chatClient;

    public OpenAIService(OpenAiChatModel model) {

        this.chatClient = ChatClient.create(model);
    }

    @Override
    public String chat(String message) {

        return chatClient.prompt().user(message).call().content();
    }
}