package com.sugarfit.service_starter_template.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ExampleRequest {

    @NotBlank(message = "userId must not be blank")
    private String userId;

    @NotNull(message = "value must not be null")
    @PositiveOrZero(message = "value must be >= 0")
    private Integer value;

    public ExampleRequest() {}

    public ExampleRequest(String userId, Integer value) {
        this.userId = userId;
        this.value = value;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getValue() {
        return value;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
