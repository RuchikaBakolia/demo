package com.example.demo.service;

import com.newrelic.telemetry.Attributes;
import com.newrelic.telemetry.OkHttpPoster;
import com.newrelic.telemetry.TelemetryClient;
import com.newrelic.telemetry.events.Event;
import com.newrelic.telemetry.events.EventBatch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Map;

@Service
public class NewRelicService {

    @Value("${newrelic.key}")
    private String newRelicKey;

    public void sendEvent(String name, Map<String, String> attributes) {
        Attributes eventAttributes = new Attributes();
        attributes.forEach(eventAttributes::put);
        Event event = new Event(name, eventAttributes);
        getClient().sendBatch(new EventBatch(Collections.singleton(event)));
    }

    private TelemetryClient getClient() {
        return TelemetryClient.create(
                () -> new OkHttpPoster(Duration.of(10, ChronoUnit.SECONDS)),
                newRelicKey);
    }
}
