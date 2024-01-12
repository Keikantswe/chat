package com.keikantswe.chat.kafkaService;

import com.keikantswe.chat.entity.MessageEntity;
import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.repository.MessageRepository;
import com.keikantswe.chat.repository.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class Consumer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;


    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "user-conversations", groupId = "conversation-group")
    public void consume(String message) {
        try {
            String[] parts = message.split(":");
            if (parts.length >= 3) {
                String senderUsername = parts[0].trim();
                String content = parts[1].trim();
                String receiverUsername = parts[2].trim();

                UserEntity sender = userRepository.findByUserName(senderUsername);
                UserEntity receiver = userRepository.findByUserName(receiverUsername);

                if (sender != null && receiver != null) {
                    MessageEntity messageEntity = MessageEntity.builder()
                            .sender(sender)
                            .receiver(receiver)
                            .message(content)
                            .build();
                    messageRepository.save(messageEntity);
                    logger.info("Saved conversation to the database.");
                }else {
                    logger.warn("Invalid sender or receiver - Sender: {}, Receiver: {}",senderUsername ,receiverUsername);
                }
            }


        } catch (Exception e) {
            logger.error("Error processing Kafka message - {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
