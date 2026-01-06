package com.example.Library.dto.response;

import java.util.ArrayList;
import java.util.List;

public class BookDto{
    private String title;
    private String isbn;
    private double price;
    private String authorName;
    private List<ReaderDto> readerDtos = new ArrayList<>();

    public BookDto(String title, String isbn, double price, String authorName){
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.authorName = authorName;
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

    public String getAuthorName( ){
        return authorName;
    }

    public List<ReaderDto> getReaderDtos( ){
        return readerDtos;
    }
}
