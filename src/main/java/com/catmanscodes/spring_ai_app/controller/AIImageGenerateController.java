package com.catmanscodes.spring_ai_app.controller;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/image")
public class AIImageGenerateController {

    private final OpenAiImageModel imageModel;

    public AIImageGenerateController(OpenAiImageModel imageModel) {
        this.imageModel = imageModel;
    }

    //api example: -> /api/image?prompt=a cat is typing a code on a laptop
    @GetMapping
    public ResponseEntity<String> generateImage(@RequestParam String prompt){

        ImageResponse response = imageModel.call(new ImagePrompt(prompt));

        var output = response.getResult().getOutput();

        String result = (output.getUrl() != null)
                ? output.getUrl()
                : output.getB64Json();

        return ResponseEntity.ok(result);
    }
}
