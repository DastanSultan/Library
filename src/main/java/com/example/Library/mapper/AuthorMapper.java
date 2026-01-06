package com.example.Library.mapper;

import com.example.Library.dto.response.AuthorDto;
import com.example.Library.dto.response.BookDto;
import com.example.Library.model.Author;
import com.example.Library.model.Book;

import java.util.stream.Collectors;

public class AuthorMapper{
    public static AuthorDto toAuthorDto(Author author){
        var books = author.getBooks()
                .stream()
                .map(AuthorMapper::bookDto)
                .collect(Collectors.toList());
        return new AuthorDto(author.getFullName(), author.getEmail(), books);
    }
    public static BookDto bookDto(Book book){
        return new BookDto(book.getTitle(),
                book.getIsbn(),
                book.getPrice(),
                book.getAuthor().getFullName());
    }
}
