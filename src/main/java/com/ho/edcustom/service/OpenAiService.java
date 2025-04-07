package com.ho.edcustom.service;

import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.enumSet.ErrorCode;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
public class OpenAiService {
    private final ChatModel chatModel;

    public OpenAiService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }
    public ChatResponse aiResponse(String message) {

        ChatResponse chatResponse = chatModel.call(
                new Prompt(
                        "안녕"+





                        message,
                        OpenAiChatOptions.builder()
                                .model("gpt-4o")
                                .temperature(0.7)
                                .build()
                ));


        //return new HttpResponse(HttpStatus.OK, ErrorCode.SUCCESS,chatResponse);
        return chatResponse;
    }
}
