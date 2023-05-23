package com.emergentes.iot.exceptions;

public class LoginException extends Exception {
    public LoginException(String message, Throwable cause){ super(message, cause); }

    public LoginException(String message){ super(message); }
}
