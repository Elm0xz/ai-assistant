package com.pretz.aiassistant;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateResponse(String input) {
        var result = assistantService.processInput(input);
        return ResponseEntity.ok(result);
    }
}
