package com.apozdniakov.metrics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherRequester {
    private final String openWeatherToken;
    private final RestTemplate restTemplate;


    public WeatherRequester(@Value("${openWeatherToken}") String openWeatherToken) {
        this.openWeatherToken = openWeatherToken;
        this.restTemplate = new RestTemplate();
    }

    public synchronized double getTemperature() {
        try {
            Thread.sleep(1000);
            String url = "https://api.openweathermap.org/data/2.5/weather?id=498817&units=metric&appid=" + openWeatherToken;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode body = mapper.readTree(response.getBody());
            return body.path("main").get("temp").doubleValue();
        } catch (JsonProcessingException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
