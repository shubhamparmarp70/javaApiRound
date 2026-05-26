package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/employee")
    public Map<String, Object> getEmployee() {

        return Map.of(
                "id", 124,
                "name", "Shubham Rajput",
                "salary", 70000
        );
    }
}