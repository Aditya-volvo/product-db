package com.product.exceptionhandle;

import com.product.dto.ErrorResponse;
import com.product.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleIdNotFoundException(IdNotFoundException ex){
     ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
     return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
