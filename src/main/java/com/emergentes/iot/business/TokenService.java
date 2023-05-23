package com.emergentes.iot.business;

import com.emergentes.iot.dao.TokenDAO;
import com.emergentes.iot.dao.entity.TokenEntity;
import com.emergentes.iot.exceptions.InvalidTokenException;
import com.emergentes.iot.exceptions.TokenGenerationException;
import com.emergentes.iot.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenService {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TokenService.class);


    @Autowired
    private TokenDAO tokenDAO;

    public String generateToken() throws TokenGenerationException {
        try{
            Token token = new Token();
            String token_value= UUID.randomUUID().toString();
            token.setTokenValue(token_value);
            token.setCreatedAt(LocalDateTime.now());
            TokenEntity tokenEntity = new TokenEntity(token);
            tokenDAO.save(tokenEntity);
            return token.getTokenValue();
        }catch(Exception e){
            LOGGER.error(e.getMessage(), "Error saving the token");
            throw new TokenGenerationException(e.getMessage());
        }
    }

    public void checkToken(String token) throws InvalidTokenException {
        if (!tokenDAO.isValidToken(token)) {
            throw new InvalidTokenException("Invalid token");
        }
    }

}

