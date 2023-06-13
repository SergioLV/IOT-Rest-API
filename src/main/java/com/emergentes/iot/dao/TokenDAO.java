package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.TokenEntity;
import com.emergentes.iot.dao.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


@Component
public class TokenDAO {

    @Autowired
    private TokenRepository tokenRepository;

    @Transactional
    public void save(TokenEntity tokenEntity){
        tokenRepository.save(tokenEntity);
    }

//    TODO: Get rid of this token and return what should return. Dont insert business logic here.
    @Transactional(readOnly = true)
    public boolean isValidToken(String token_value){
        TokenEntity tokenEntity = getTokenEntityByTokenValue(token_value);
        return tokenEntity != null;
    }

    private TokenEntity getTokenEntityByTokenValue(String token_value){
        return tokenRepository.findById(token_value).orElse(null);
    }
    private static boolean isCreatedWithinSeconds(String timestampString, long seconds) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime timestamp = LocalDateTime.parse(timestampString, formatter);
        Instant timestampInstant = timestamp.toInstant(ZoneOffset.UTC);
        Instant currentInstant = Instant.now();
        long timeDifference = currentInstant.getEpochSecond() - timestampInstant.getEpochSecond();
        return seconds <= timeDifference;
    }

}
