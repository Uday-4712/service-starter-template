package com.sugarfit.service_starter_template.dto;

public class ExampleResponse {

    private String status;
    private String requestId;

    public ExampleResponse() {}

    public ExampleResponse(String status, String requestId) {
        this.status = status;
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
