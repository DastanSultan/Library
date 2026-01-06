package com.example.Library.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

public class BookCreateDto{
    @NotBlank(message = "Title can be not empty")
    private String title;
    @NotBlank(message = "Isbn can be not empty")
    private String isbn;
    @Positive(message = "Price must be positive")
    @Max(value = 1000, message = "Price must not exceed 1000")
    private double price;
    private Long authorId;
    private List<Long> readerId = new ArrayList<>();

    public BookCreateDto(String title, String isbn, double price, Long authorId, List<Long> readerId){
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.authorId = authorId;
        this.readerId = readerId;
    }

    public String getTitle( ){
        return title;
    }

    public String getIsbn( ){
        return isbn;
    }

    public double getPrice( ){
        return price;
    }

    public Long getAuthorId( ){
        return authorId;
    }

    public List<Long> getReaderId( ){
        return readerId;
    }
}
