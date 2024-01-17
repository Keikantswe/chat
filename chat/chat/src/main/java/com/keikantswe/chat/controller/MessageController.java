package com.keikantswe.chat.controller;

import com.keikantswe.chat.kafkaService.Consumer;
import com.keikantswe.chat.service.MessageService;
import com.keikantswe.chat.service.MessageServiceImpl;
import com.keikantswe.chat.response.ApiResponse;
import com.keikantswe.chat.response.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chat")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private Consumer consumer;

    @PostMapping("/send-message")
    public ResponseEntity<ApiResponse> sendMessage(@RequestBody MessageRequest messageRequest){
        messageService.sendMessage(
                messageRequest.getSenderUsername(),
                messageRequest.getReceiverUsername(),
                messageRequest.getMessageContent()
        );

        return ResponseEntity.ok(new ApiResponse("Message sent successfully"));
    }
}
