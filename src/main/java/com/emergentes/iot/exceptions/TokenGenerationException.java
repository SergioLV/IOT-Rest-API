package com.emergentes.iot.exceptions;

public class TokenGenerationException extends Exception {
    public TokenGenerationException(String message, Throwable cause){ super(message, cause); }

    public TokenGenerationException(String message){ super(message); }
}
