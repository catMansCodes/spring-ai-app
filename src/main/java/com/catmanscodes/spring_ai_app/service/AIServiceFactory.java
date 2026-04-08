package com.catmanscodes.spring_ai_app.service;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class AIServiceFactory {

    private final Map<String, AIService> services;

    public AIServiceFactory(Map<String, AIService> services) {
        this.services = services;
    }

    public AIService getService(String provider) {

        return switch (provider.toLowerCase()) {
            case "openai" -> services.get("openAIService");
            case "ollama" -> services.get("ollamaService");
            case "gemini" -> services.get("geminiService");
            default -> throw new IllegalArgumentException("Invalid provider: " + provider);
        };
    }
}