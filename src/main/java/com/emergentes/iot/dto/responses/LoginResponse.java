package com.emergentes.iot.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    public String token;
    public int expiresIn;

    public LoginResponse(String token, int expires_in) {
        this.token = token;
        this.expiresIn = expires_in;
    }
}
