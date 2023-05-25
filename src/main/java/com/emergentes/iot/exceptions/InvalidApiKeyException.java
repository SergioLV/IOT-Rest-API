package com.emergentes.iot.exceptions;

public class InvalidApiKeyException extends Exception {
    public InvalidApiKeyException(String message, Throwable cause){ super(message, cause); }
    public InvalidApiKeyException(String message){ super(message); }
}
