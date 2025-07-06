package com.airtribe.projects.news.aggregator.controller;
import com.example.newsapp.entity.User;
import com.example.newsapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
@RequiredArgsConstructor
public class PreferenceController {

    private final UserRepository userRepository;

    @GetMapping
    public String getPreferences(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        return user.getPreference();
    }

    @PutMapping
    public String updatePreferences(@AuthenticationPrincipal UserDetails userDetails,
                                    @RequestBody String preference) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        user.setPreference(preference);
        userRepository.save(user);
        return "Preferences updated";
    }
}
