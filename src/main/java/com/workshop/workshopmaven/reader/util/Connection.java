package com.workshop.workshopmaven.reader.util;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class Connection {

    private String addressBaseUrl;

    public Connection() {
        this.addressBaseUrl = "http://localhost:8081";
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(addressBaseUrl).build();
    }

}
