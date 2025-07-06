package com.airtribe.projects.news.aggregator.service;

import com.example.newsapp.entity.User;
import com.example.newsapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class NewsService {

    @Value("${newsapi.key}")
    private String apiKey;

    private final UserRepository userRepository;

    private final WebClient webClient = WebClient.create("https://gnews.io/api/v4");

    public Object fetchNewsForUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        String topic = user.getPreference();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/search")
                        .queryParam("apikey", apiKey)
                        .queryParam("q", topic != null ? topic : "general")
                        .queryParam("lang", "en")
                        .queryParam("country", "us")
                        .queryParam("max", "10")
                        .build())
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }

    public Object searchNewsByKeyword(String keyword) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/search")
                        .queryParam("token", apiKey)
                        .queryParam("q", keyword)
                        .queryParam("lang", "en")
                        .queryParam("country", "us")
                        .queryParam("max", "10")
                        .build())
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}