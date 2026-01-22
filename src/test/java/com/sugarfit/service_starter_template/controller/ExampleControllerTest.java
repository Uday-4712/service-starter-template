package com.sugarfit.service_starter_template.controller;

import com.sugarfit.service_starter_template.dto.ExampleRequest;
import com.sugarfit.service_starter_template.dto.ExampleResponse;
import com.sugarfit.service_starter_template.exception.GlobalExceptionHandler;
import com.sugarfit.service_starter_template.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ExampleControllerTest {

    private final ExampleService exampleService = mock(ExampleService.class);
    private final MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(new ExampleController(exampleService))
            .setControllerAdvice(new GlobalExceptionHandler())
            .build();

    @Test
    void returnsSuccessResponse() throws Exception {
        ExampleResponse expected = new ExampleResponse("SUCCESS", "request-id-123");
        when(exampleService.process(any(ExampleRequest.class))).thenReturn(expected);

        mockMvc.perform(post("/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "userId": "123",
                                  "value": 42
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.requestId").value("request-id-123"));
    }

    @Test
    void validatesRequestBody() throws Exception {
        mockMvc.perform(post("/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "userId": "",
                                  "value": null
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.validationErrors.userId").value("userId must not be blank"))
                .andExpect(jsonPath("$.validationErrors.value").value("value must not be null"));
    }
}

