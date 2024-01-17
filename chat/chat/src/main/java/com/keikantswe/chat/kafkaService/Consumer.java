package com.keikantswe.chat.kafkaService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keikantswe.chat.entity.MessageEntity;
import com.keikantswe.chat.entity.UserEntity;
import com.keikantswe.chat.repository.MessageRepository;
import com.keikantswe.chat.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Slf4j
public class Consumer {

    @Autowired
    MessageRepository messageRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(ConsumerRecord<String, String> record){
        log.info(String.format("Received Kafka message -> key: %s, value: %s", record.key(), record.value()));


        try {
            ObjectMapper objectMapper = new ObjectMapper();

            MessageEntity messageEntity = objectMapper.readValue(record.value(), MessageEntity.class);

            messageRepository.save(messageEntity);

        }catch (Exception e){
            LOGGER.error("Error processing kafka message" + e.getMessage());
            e.printStackTrace();
        }

    }

}
