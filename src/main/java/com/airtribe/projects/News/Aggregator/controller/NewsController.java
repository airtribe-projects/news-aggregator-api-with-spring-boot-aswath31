package com.airtribe.projects.news.aggregator.controller;


import com.example.newsapp.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public Object fetchNews(@AuthenticationPrincipal UserDetails userDetails) {
        return newsService.fetchNewsForUser(userDetails.getUsername());
    }

    @GetMapping("/search/{keyword}")
    public Object searchNews(@PathVariable String keyword) {
        return newsService.searchNewsByKeyword(keyword);
    }
}