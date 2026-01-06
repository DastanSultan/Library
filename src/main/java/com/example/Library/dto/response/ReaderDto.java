package com.example.Library.dto.response;

import java.util.ArrayList;
import java.util.List;

public class ReaderDto{
    private String fullName;
    private String email;
    private List<BookDto> bookDtos = new ArrayList<>();

    public ReaderDto(String fullName, String email){
        this.fullName = fullName;
        this.email = email;
    }
    public String getFullName( ){
        return fullName;
    }

    public String getEmail( ){
        return email;
    }

    public List<BookDto> getBookDtos( ){
        return bookDtos;
    }
}
