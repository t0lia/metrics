package com.apozdniakov.metrics;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoMetricsScheduler {

    private final DemoMetrics demoMetrics;

    public DemoMetricsScheduler(DemoMetrics demoMetrics) {
        this.demoMetrics = demoMetrics;
    }

    @Scheduled(fixedRate = 60000)
    public void triggerCustomMetrics() throws JsonProcessingException {
        demoMetrics.getRandomMetricsData();
    }
}
