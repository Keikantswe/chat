package com.keikantswe.chat.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keikantswe.chat.entity.MessageEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    public String WriteValueAsStringUsingObjectMapper(ObjectMapper objectMapper, MessageEntity messageEntity){
        try {
            return objectMapper.writeValueAsString(messageEntity);
        } catch (Exception e){
            e.printStackTrace();
            return "Null";
        }
    }
}
