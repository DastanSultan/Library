package com.example.Library.exception.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationExceptionHandler{
    private LocalDateTime localDateTime = LocalDateTime.now();
    private int status;
    private List<FieldErrorDto> errorResponses;

    public ValidationExceptionHandler(int status, List<FieldErrorDto> errorResponses){
        this.status = status;
        this.errorResponses = errorResponses;
    }

    public LocalDateTime getLocalDateTime( ){
        return localDateTime;
    }

    public int getStatus( ){
        return status;
    }

    public List<FieldErrorDto> getErrorResponses( ){
        return errorResponses;
    }
}
