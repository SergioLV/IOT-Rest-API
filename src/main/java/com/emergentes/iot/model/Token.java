package com.emergentes.iot.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Token {
    private String tokenValue;
    private LocalDateTime createdAt;
}

