package com.emergentes.iot.service.api;

import com.emergentes.iot.exceptions.*;
import com.emergentes.iot.service.responses.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Calendar;

@RestControllerAdvice
public class IotErrorHandlerController {
//    TODO: Check response status
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(IotErrorHandlerController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptions(Exception e){
        String message = "Oops! Something went wrong :c";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ErrorResponse> exceptions(LoginException e){
        String message = "Bad credentials";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> exceptions(DataIntegrityViolationException e){
        String message = e.getMessage();
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> exceptions(MissingRequestHeaderException e){
        String message = "Bearer token missing";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(InvalidCompanyIdException.class)
    public ResponseEntity<ErrorResponse> exceptions(InvalidCompanyIdException e){
        String message = "The company with id " + e.getMessage() + " does not exists.";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(InvalidApiKeyException.class)
    public ResponseEntity<ErrorResponse> exceptions(InvalidApiKeyException e){
        String message = "Invalid Api Key";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }
 @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<ErrorResponse> exceptions(InvalidDataAccessResourceUsageException e){
        String message = e.getMessage();
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorResponse> exceptions(InvalidTokenException e){
        String message = "Invalid Token";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }@ExceptionHandler(BadCategoryException.class)
    public ResponseEntity<ErrorResponse> exceptions(BadCategoryException e){
        String message = "Sorry, category not supported. :(";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }



}
