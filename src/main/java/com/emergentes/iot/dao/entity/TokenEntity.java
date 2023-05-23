package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Token;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
public class TokenEntity {

    @Id
    @Column(name = "token_value")
    private String token_value;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


    public TokenEntity(Token token) {
        this.token_value = token.getTokenValue();
        this.createdAt = token.getCreatedAt();
    }

    public TokenEntity() {

    }

    public String getToken_value() {
        return token_value;
    }

    public void setToken_value(String token_value) {
        this.token_value = token_value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTokenValue() {
        return token_value;
    }

    public void setTokenValue(String token) {
        this.token_value = token;
    }

}

