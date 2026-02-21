package com.example.nbaapi.service;

import com.example.nbaapi.dto.NbaResponsive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NbaService {

    @Value("${allsports.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public NbaService(WebClient webClient) {
        this.webClient = webClient;
    }

    public NbaResponsive getNbaResponsive() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/basketball/")
                        .queryParam("met", "Standings")
                        .queryParam("leagueId", "787")
                        .queryParam("APIkey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(NbaResponsive.class)
                .block();
    }
}
