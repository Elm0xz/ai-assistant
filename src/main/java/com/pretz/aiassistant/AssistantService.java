package com.pretz.aiassistant;

import org.springframework.stereotype.Service;

@Service
public class AssistantService {

    private final AiAgent agent;

    public AssistantService(AiAgent agent) {
        this.agent = agent;
    }

    public String processInput(String input) {
        return agent.processInput(input);
    }
}
