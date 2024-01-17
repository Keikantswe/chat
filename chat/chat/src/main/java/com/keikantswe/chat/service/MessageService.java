package com.keikantswe.chat.service;

public interface MessageService {


    void sendMessage(String senderUsername, String receiverUsername, String messageContent);
}
