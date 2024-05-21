package com.example.demo.service;

import com.example.demo.model.GitHubStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class GitHubStatusService {

    private static final String GITHUB_STATUS_URL = "https://www.githubstatus.com/api/v2/status.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GitHubStatus fetchGitHubStatus() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(GITHUB_STATUS_URL, String.class);
        String json = response.getBody();
        System.out.println(json);

        try {
            return objectMapper.readValue(json, GitHubStatus.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse GitHub status JSON", e);
        }
    }
}
