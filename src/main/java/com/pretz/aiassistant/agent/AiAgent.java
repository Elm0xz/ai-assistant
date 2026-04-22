package com.pretz.aiassistant.agent;

import com.embabel.agent.api.common.Ai;
import com.pretz.aiassistant.dto.TriviaRequest;
import com.pretz.aiassistant.dto.TriviaResponse;

public interface AiAgent {

    TriviaResponse processInput(TriviaRequest input, Ai ai);
}
