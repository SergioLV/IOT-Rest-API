package com.emergentes.iot.exceptions;

public class CompanyLocationException extends Exception {
    public CompanyLocationException(String message, Throwable cause){ super(message, cause); }
    public CompanyLocationException(String message){ super(message); }
}
