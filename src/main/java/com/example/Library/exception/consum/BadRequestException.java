package com.example.Library.exception.consum;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
