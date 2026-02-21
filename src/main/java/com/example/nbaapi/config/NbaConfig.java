package com.example.nbaapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class NbaConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://apiv2.allsportsapi.com")
                .build();
    }
}
