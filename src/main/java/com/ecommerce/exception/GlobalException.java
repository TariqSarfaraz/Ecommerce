package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> resourceNotFound(ResourceNotFoundException exception) {

        Error error = new Error(exception.getMessage(), 404, new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
