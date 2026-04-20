package com.pretz.aiassistant;

import com.embabel.agent.api.annotation.AchievesGoal;
import com.embabel.agent.api.annotation.Action;
import com.embabel.agent.api.annotation.Agent;
import com.embabel.agent.api.common.Ai;
import com.pretz.aiassistant.dto.TriviaRequest;
import com.pretz.aiassistant.dto.TriviaResponse;

@Agent(description = "Ollama AI agent for generating responses")
public class OllamaAgent implements AiAgent {

    @Override
    @Action
    @AchievesGoal(description = "Generates a response based on the input prompt")
    public TriviaResponse processInput(TriviaRequest input, Ai ai) {
        return ai.withDefaultLlm().createObject(
                """
                        Provide some trivia on topic mentioned by user: %s
                        """.formatted(input), TriviaResponse.class
        );
    }
}
