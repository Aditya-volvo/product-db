package com.product.exception;

public class IdNotFoundException extends  RuntimeException{
    public IdNotFoundException(String message) {
        super(message);
    }
}
