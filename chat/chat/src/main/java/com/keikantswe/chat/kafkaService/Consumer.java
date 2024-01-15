package com.keikantswe.chat.kafkaService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keikantswe.chat.configuration.JacksonObjectMapperConfig;
import com.keikantswe.chat.entity.MessageEntity;
import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.repository.MessageRepository;
import com.keikantswe.chat.repository.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class Consumer {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JacksonObjectMapperConfig jacksonObjectMapperConfig;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.chatting}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(String jsonString){

        try {
            LOGGER.warn(String.format("Event Message Received -> %s", jsonString));

            ObjectMapper objectMapper = jacksonObjectMapperConfig.objectMapper();
            MessageEntity messageEntity = objectMapper.readValue(jsonString, MessageEntity.class);


            if (messageEntity != null){

                //Getting sender and receiver usernames
                String senderUsername = messageEntity.getSender().getUserName();
                String receiverUsername = messageEntity.getReceiver().getUserName();

                UserEntity sender = userRepository.findByUserName(messageEntity.getSender().getUserName());
                UserEntity receiver = userRepository.findByUserName(receiverUsername);

                //Saving  the message to database.
                if (sender != null && receiver != null){
                    messageEntity.setSender( sender);
                    messageEntity.setReceiver(receiver);

                    messageRepository.save(messageEntity);

                    LOGGER.info("Saved message to database");
                } else {
                    LOGGER.warn("invalid Sender or Receiver " + senderUsername + receiverUsername);
                }
            } else {
                LOGGER.warn("Failed to deserialize the message");
            }

        }catch (Exception e){
            LOGGER.error("Error processing kafka message" + e.getMessage());
            e.printStackTrace();
        }

    }

}
