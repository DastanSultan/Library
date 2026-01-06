package com.example.Library.exception.dto;

import java.time.LocalDateTime;

public class ErrorResponse{
    private LocalDateTime localDateTime;
    private int status;
    private String error;
    private String message;
    private String path;
    public ErrorResponse(int status,
                         String error,
                         String message,
                         String path){
        this.localDateTime = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getLocalDateTime( ){
        return localDateTime;
    }

    public int getStatus( ){
        return status;
    }

    public String getError( ){
        return error;
    }

    public String getMessage( ){
        return message;
    }

    public String getPath( ){
        return path;
    }
}
