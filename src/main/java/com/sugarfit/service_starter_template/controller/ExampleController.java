package com.sugarfit.service_starter_template.controller;

import com.sugarfit.service_starter_template.dto.ExampleRequest;
import com.sugarfit.service_starter_template.dto.ExampleResponse;
import com.sugarfit.service_starter_template.service.ExampleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/example")
    public ResponseEntity<ExampleResponse> process(@Valid @RequestBody ExampleRequest request) {
        ExampleResponse response = exampleService.process(request);
        return ResponseEntity.ok(response);
    }
}
