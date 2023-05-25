package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Token;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tokens")
public class TokenEntity {

    @Id
    @Column(name = "token_value")
    private String tokenValue;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


    public TokenEntity(Token token) {
        this.tokenValue = token.getTokenValue();
        this.createdAt = token.getCreatedAt();
    }

    public TokenEntity() {

    }
}

