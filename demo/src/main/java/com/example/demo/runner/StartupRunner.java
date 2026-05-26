package com.example.demo.runner;

import com.example.demo.service.ApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final ApiService apiService;

    public StartupRunner(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void run(String... args) {

        System.out.println("Application Started...");

        apiService.executeFlow();
    }
}