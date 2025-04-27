package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Define RestTemplate bean for making HTTP requests
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // You can add more configuration methods here as required, such as custom converters, authentication setup, etc.
}
