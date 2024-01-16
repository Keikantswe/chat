package com.keikantswe.chat.kafkaService;

import com.keikantswe.chat.configuration.JacksonObjectMapperConfig;
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

    @Autowired
    private JacksonObjectMapperConfig jacksonObjectMapperConfig;

    public void sendMessage(String sender, String receiver, String message){

        try {
            String key = sender + receiver;

            MessageEntity messageEntity = new MessageEntity(sender , receiver, message);

            String value = jacksonObjectMapperConfig.WriteValueAsStringUsingObjectMapper(jacksonObjectMapperConfig.objectMapper(), messageEntity);


            kafkaTemplate.send(TOPIC, key, value);
            log.info("Message sent Successfully" + message);

        } catch (Exception e){

            log.error("Failed to send message" + e.getMessage());
            e.printStackTrace();
        }

    }
}
