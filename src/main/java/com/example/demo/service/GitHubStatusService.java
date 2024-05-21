package com.example.demo.service;

import com.example.demo.model.GitHubStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Slf4j
@Service
public class GitHubStatusService {

    private static final String GITHUB_STATUS_URL = "https://www.githubstatus.com/api/v2/status.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GitHubStatus fetchGitHubStatus() {
        RestTemplate restTemplate = new RestTemplate();
        log.info("Calling Github status for getting status");
        long callStartTime = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity(GITHUB_STATUS_URL, String.class);
        log.info("Github status API took '{}' milliseconds", System.currentTimeMillis() - callStartTime);
        String json = response.getBody();
        try {
            return objectMapper.readValue(json, GitHubStatus.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse GitHub status JSON", e);
        }
    }
}
