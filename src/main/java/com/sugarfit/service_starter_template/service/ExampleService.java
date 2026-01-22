package com.sugarfit.service_starter_template.service;

import com.sugarfit.service_starter_template.dto.ExampleRequest;
import com.sugarfit.service_starter_template.dto.ExampleResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExampleService {

    public ExampleResponse process(ExampleRequest request) {
        String requestId = UUID.randomUUID().toString();
        return new ExampleResponse("SUCCESS", requestId);
    }
}
