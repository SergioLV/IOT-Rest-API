package com.emergentes.iot.exceptions;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(String message, Throwable cause){ super(message, cause); }

    public InvalidTokenException(String message){ super(message); }
}
