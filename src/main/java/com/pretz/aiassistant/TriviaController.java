package com.pretz.aiassistant;

import com.pretz.aiassistant.dto.TriviaRequest;
import com.pretz.aiassistant.dto.TriviaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TriviaController {

    private final TriviaService triviaService;

    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @PostMapping("/trivia")
    public ResponseEntity<TriviaResponse> provideTrivia(@RequestBody TriviaRequest input) {
        var result = triviaService.processInput(input);
        return ResponseEntity.ok(result);
    }
}
