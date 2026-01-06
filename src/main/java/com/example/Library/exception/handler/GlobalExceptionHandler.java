package com.example.Library.exception.handler;

import com.example.Library.exception.consum.BadRequestException;
import com.example.Library.exception.consum.ResourseNotFoundException;
import com.example.Library.exception.dto.ErrorResponse;
import com.example.Library.exception.dto.FieldErrorDto;
import com.example.Library.exception.dto.ValidationExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler( ResourseNotFoundException.class)
    public ResponseEntity<ErrorResponse>  exceptionNotFound (
            ResourseNotFoundException e,
            HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new com.example.Library.exception.dto.ErrorResponse(
                        HttpStatus.NOT_FOUND.value(), 
                        HttpStatus.NOT_FOUND.name(),
                        e.getMessage(),
                        request.getRequestURI()
                        ));
    }

    @ExceptionHandler( BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(
            BadRequestException e, HttpServletRequest request
    ){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(
                        HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.name(),
                        e.getMessage(),
                        request.getRequestURI()
                        ));
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionHandler> validationEx(MethodArgumentNotValidException e){
        List<FieldErrorDto> errorDtos = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(a -> new FieldErrorDto(a.getField(), a.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest().body(
                new ValidationExceptionHandler(400, errorDtos)
        );
    }
}
