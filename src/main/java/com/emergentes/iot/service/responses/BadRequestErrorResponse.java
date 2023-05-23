package com.emergentes.iot.service.responses;

import java.util.List;

public class BadRequestErrorResponse {
    private String message;
    private List<String> errors;
    private Long timestamp;

    public BadRequestErrorResponse(String message, List<String> errors, long timestamp) {
        this.message = message;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
