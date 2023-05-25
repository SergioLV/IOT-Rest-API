package com.emergentes.iot.dto.requests;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginRequest {
    @NotNull(message = "Username is mandatory")
    private String username;
    @NotNull(message = "Password is mandatory")
    private String password;
}
