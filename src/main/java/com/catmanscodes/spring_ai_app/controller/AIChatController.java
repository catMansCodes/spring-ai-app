package com.catmanscodes.spring_ai_app.controller;

import com.catmanscodes.spring_ai_app.service.AIService;
import com.catmanscodes.spring_ai_app.service.AIServiceFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class AIChatController {

    private final AIServiceFactory factory;

    public AIChatController(AIServiceFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/{provider}/{message}")
    public ResponseEntity<String> chat(
            @PathVariable String provider,
            @PathVariable String message) {

        AIService service = factory.getService(provider);

        String response = service.chat(message);

        return ResponseEntity.ok(response);
    }
}
