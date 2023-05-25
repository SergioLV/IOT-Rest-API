package com.emergentes.iot.exceptions;

public class InvalidCompanyIdException extends Exception {
    public InvalidCompanyIdException(String message, Throwable cause){ super(message, cause); }
    public InvalidCompanyIdException(String message){ super(message); }
}
