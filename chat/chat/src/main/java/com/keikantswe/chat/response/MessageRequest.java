package com.keikantswe.chat.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {

    private String senderUsername, receiverUsername, messageContent;

    public MessageRequest() {
    }

    public MessageRequest(String senderUsername, String receiverUsername, String messageContent) {
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.messageContent = messageContent;
    }


}
