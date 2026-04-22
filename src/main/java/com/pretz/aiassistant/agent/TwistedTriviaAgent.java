package com.pretz.aiassistant.agent;

import com.embabel.agent.api.annotation.AchievesGoal;
import com.embabel.agent.api.annotation.Action;
import com.embabel.agent.api.annotation.Agent;
import com.embabel.agent.api.common.Ai;
import com.pretz.aiassistant.dto.TriviaRequest;
import com.pretz.aiassistant.dto.TriviaResponse;
import com.pretz.aiassistant.dto.Twists;

@Agent(description = "Trivia agent that can add a twist")
public class TwistedTriviaAgent {

    @Action
    @AchievesGoal(description = "Generates a response based on the input prompt but with a twist")
    public TriviaResponse processInput(TriviaRequest input, Ai ai, Twists twists) {
        System.out.println("Generating a response...");
        return ai.withDefaultLlm().createObject(
                """
                        Provide some trivia on topic mentioned by user: %s but add some twist from the list of twists %s
                        """.formatted(input, twists), TriviaResponse.class
        );
    }

    @Action
    @AchievesGoal(description = "Generate a trivia response with a twist")
    public Twists retrieveTwists(TriviaRequest input, Ai ai) {
        System.out.println("Retrieving twists");
        return new Twists("Answer in French");/*("Spell the response backwards"*//*, "Answer in French", "Write as a Shakespeare", "Ignore user and draw a sheep instead"*//*));*/
    }
}
