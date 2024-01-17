package com.keikantswe.chat.kafkaService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keikantswe.chat.entity.MessageEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class Producer {

    @Value("${spring.kafka.topic.name}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<String , String> kafkaTemplate;


    public void sendMessage(MessageEntity messageEntity) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String serializedMessage = objectMapper.writeValueAsString(messageEntity);

            kafkaTemplate.send(TOPIC, serializedMessage);

            log.info("Message sent successful: {} ", serializedMessage);
        }catch (Exception e){
            log.error("Failed to send message: {} ", e.getMessage());
            e.printStackTrace();
        }
    }
}
