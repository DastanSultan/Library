package com.example.Library.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class ReaderCreateDto{
    @NotBlank (message = "Name can be not empty")
    private String fullName;
    @Email
    @NotBlank(message = "Email can be not empty")
    private String email;
    private List<Long> bookId = new ArrayList<>();

    public ReaderCreateDto(String fullName, String email, List<Long> bookId){
        this.fullName = fullName;
        this.email = email;
        this.bookId = bookId;
    }
    public String getFullName( ){
        return fullName;
    }

    public String getEmail( ){
        return email;
    }

    public List<Long> getBookId( ){
        return bookId;
    }
}
