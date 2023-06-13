package com.emergentes.iot.exceptions;

public class BadCategoryException extends Exception {
    public BadCategoryException(String message, Throwable cause){ super(message, cause); }
    public BadCategoryException(String message){ super(message); }
}
