package com.emergentes.iot.dto.responses;

public class LoginResponse {

    public String token;
    public int expires_in;

    public String getToken() {
        return token;
    }

    public LoginResponse(String token, int expires_in) {
        this.token = token;
        this.expires_in = expires_in;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
