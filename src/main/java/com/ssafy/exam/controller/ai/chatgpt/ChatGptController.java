package com.ssafy.exam.controller.ai.chatgpt;

import com.ssafy.exam.model.service.ai.chatgpt.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/ai/chatgpt")
public class ChatGptController {
    @Autowired
    private ChatGptService chatGptService;

    @PostMapping("chat")
    public ResponseEntity<String> chat(@RequestBody String message) throws IOException {
        String answer = chatGptService.createChat(message);
        return ResponseEntity.ok(answer);
    }

}
