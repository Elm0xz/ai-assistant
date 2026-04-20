package com.pretz.aiassistant.agent;

import com.embabel.agent.api.annotation.AchievesGoal;
import com.embabel.agent.api.annotation.Action;
import com.embabel.agent.api.annotation.Agent;
import com.embabel.agent.api.common.Ai;
import com.pretz.aiassistant.dto.TriviaRequest;
import com.pretz.aiassistant.dto.TriviaResponse;

@Agent(description = "Plain trivia agent")
public class TriviaAgent {

    @Action
    @AchievesGoal(description = "Generate a straightforward trivia response")
    public TriviaResponse processInput(TriviaRequest input, Ai ai) {
        return ai.withDefaultLlm().createObject(
                """
                        Provide some trivia on topic mentioned by user: %s
                        """.formatted(input), TriviaResponse.class
        );
    }
}
