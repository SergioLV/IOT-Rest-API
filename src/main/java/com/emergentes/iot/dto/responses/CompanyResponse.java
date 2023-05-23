package com.emergentes.iot.dto.responses;

public class CompanyResponse {
    public String message;
    public String apikey;

    public String getMessage() {
        return message;
    }

    public CompanyResponse(String message, String apikey) {
        this.message = message;
        this.apikey = apikey;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
