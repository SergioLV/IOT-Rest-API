package com.emergentes.iot.service.api;

import com.emergentes.iot.exceptions.InvalidTokenException;
import com.emergentes.iot.exceptions.LoginException;
import com.emergentes.iot.service.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Calendar;

@RestControllerAdvice
public class IotErrorHandlerController {
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
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorResponse> exceptions(InvalidTokenException e){
        String message = "Invalid Token";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

}
