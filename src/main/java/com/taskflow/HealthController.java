package com.taskflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "TaskFlow API is running ✅");
    }

    @GetMapping("/")
    public Map<String, String> root() {
        return Map.of("message", "Welcome to TaskFlow API ✅");
    }
}

