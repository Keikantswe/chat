package com.keikantswe.chat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class Security {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder(11);
    }
}
