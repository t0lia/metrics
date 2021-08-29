package com.apozdniakov.metrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class HomeController {
    WeatherRequester weatherRequester;

    public HomeController(WeatherRequester weatherRequester) {
        this.weatherRequester = weatherRequester;
    }

    @GetMapping("temperature")
    public double temperature() {
        return weatherRequester.getTemperature();
    }
}
