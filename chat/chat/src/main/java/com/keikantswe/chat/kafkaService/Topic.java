package com.keikantswe.chat.kafkaService;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Topic {

    @Value("${spring.kafka.topic.name}")
    private String chatting ;

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(chatting)
                .build();
    }
}
