package com.example.demo.scheduler;

import com.example.demo.model.GitHubStatus;
import com.example.demo.service.GitHubStatusService;
import com.example.demo.service.NewRelicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Map;

@Slf4j
@Service
public class ScheduledTaskService {

    @Autowired
    private GitHubStatusService gitHubStatusService;

    @Autowired
    private NewRelicService newRelicService;

    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void collectAndSendMetrics() {
        GitHubStatus status = gitHubStatusService.fetchGitHubStatus();
        newRelicService.sendEvent("GithubStatus", Map.of("indicator", status.getStatus().getIndicator(),
                "description", status.getStatus().getDescription()));
        log.info("Event collected and sent to New Relic");
    }
}
