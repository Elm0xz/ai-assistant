package com.pretz.aiassistant;

import com.embabel.agent.api.invocation.AgentInvocation;
import com.embabel.agent.core.AgentPlatform;
import com.embabel.agent.core.ProcessOptions;
import com.embabel.agent.core.Verbosity;
import com.pretz.aiassistant.dto.TriviaRequest;
import com.pretz.aiassistant.dto.TriviaResponse;
import org.springframework.stereotype.Service;

@Service
public class TriviaService {

    private final AgentPlatform agentPlatform;

    public TriviaService(AgentPlatform agentPlatform) {
        this.agentPlatform = agentPlatform;
    }

    public TriviaResponse processInput(TriviaRequest input) {
        return AgentInvocation.builder(agentPlatform)
                .options(new ProcessOptions()
                        .withVerbosity(new Verbosity()
                                .showPrompts()
                                .showPlanning()
                                .showLlmResponses()
                                .debug()))
                .build(TriviaResponse.class).invoke(input);
    }
}
