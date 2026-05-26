package com.example.demo.controller;

import com.example.demo.dto.BfhlRequest;
import com.example.demo.dto.BfhlResponse;
import com.example.demo.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    private final BfhlService bfhlService;

    public ApiController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<BfhlResponse> processData(
            @RequestBody BfhlRequest request
    ) {

        BfhlResponse response =
                bfhlService.processData(request);

        return ResponseEntity.ok(response);
    }
}