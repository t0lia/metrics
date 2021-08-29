package com.apozdniakov.metrics;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DemoMetrics {
    private final Counter demoCounter;
    private final AtomicInteger demoGauge;
    private WeatherRequester weatherRequester;
    private String openWeatherToken;


    public DemoMetrics(MeterRegistry meterRegistry, WeatherRequester weatherRequester) {
        this.demoCounter = meterRegistry.counter("demo_counter");
        this.demoGauge = meterRegistry.gauge("demo_gauge", new AtomicInteger(0));
        this.weatherRequester = weatherRequester;
        this.openWeatherToken = openWeatherToken;
    }

    public void getRandomMetricsData() throws JsonProcessingException {
//        demoGauge.set(getRandomNumberInRange(0, 100));
        demoCounter.increment(getRandomNumberInRange(0, 3));
        double temp = weatherRequester.getTemperature();
        demoGauge.set((int) Math.floor(temp * 10));

        System.out.println(temp);
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
