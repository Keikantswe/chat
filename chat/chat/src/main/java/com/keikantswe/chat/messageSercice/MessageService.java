package com.keikantswe.chat.messageSercice;

import com.keikantswe.chat.entity.ContactEntity;
import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.kafkaService.Producer;
import com.keikantswe.chat.repository.ContactRepository;
import com.keikantswe.chat.repository.MessageRepository;
import com.keikantswe.chat.repository.UserRepository;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Producer producer;
    public void sendConversation(String senderUsername, String receiverUsername, String message){
        UserEntity sender = userRepository.findByUserName(senderUsername);
        UserEntity receiver = userRepository.findByUserName(receiverUsername);

        if(sender !=null && receiver !=null){

            ContactEntity contact = contactRepository.findByUserAndContactUser(sender, receiver).orElseThrow(()-> new ResourceNotFoundException("This is not your contact"));
            try{
                producer.sendMessage(senderUsername, receiverUsername, message);
            }catch (KafkaException e){
                throw new ResourceNotFoundException("Failed to send message");
            }
        }
    }
//    public List<Conversation> getConversations(String loggedInUsername, String contactUsername){
//        User loggedInUser = userRepository.findByUsername(loggedInUsername);
//        User contactUser = userRepository.findByUsername(contactUsername);
//        if (loggedInUser != null && contactUser != null){
//            Contact contact = contactRepository.findByUserAndContactuser(loggedInUser, contactUser).orElseThrow();
//
//            if(loggedInUser != null && contactUser !=null){
//                return conversationRepository.findBySenderAndReceiver(loggedInUser, contactUser);
//            }else {
//                throw new ResourceNotFoundException("This is not your contact");
//            }
//        }
//        return null;
//    }
}
