package com.example.demo.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.model.GitHubStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ScheduledTaskService {

    @Autowired
    private GitHubStatusService gitHubStatusService;

    @Autowired
    private NewRelicService newRelicService;

    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void collectAndSendMetrics() {
        GitHubStatus status = gitHubStatusService.fetchGitHubStatus();
        System.out.println(status.toString());
        newRelicService.sendEvent("GithubStatus", Map.of("indicator", status.getStatus().getIndicator(),
                "description", status.getStatus().getDescription()));

        System.out.println("Event collected and sent to New Relic");
    }
}
