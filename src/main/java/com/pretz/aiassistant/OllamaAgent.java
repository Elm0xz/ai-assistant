package com.pretz.aiassistant;

import com.embabel.agent.api.annotation.Agent;

@Agent(description = "Ollama AI agent for generating responses")
public class OllamaAgent implements AiAgent {

    @Override
    @Action
    public String processInput(String input) {
        return "";
    }
}
