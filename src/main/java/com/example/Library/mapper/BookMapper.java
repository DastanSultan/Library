package com.example.Library.mapper;

import com.example.Library.dto.response.BookDto;
import com.example.Library.dto.response.ReaderDto;
import com.example.Library.model.Book;

import java.util.stream.Collectors;

public class BookMapper {

    public static BookDto bookDto(Book book){
        BookDto dto = new BookDto(
                book.getTitle(),
                book.getIsbn(),
                book.getPrice(),
                book.getAuthor().getFullName()
        );

        dto.getReaderDtos().addAll(
                book.getReaders()
                        .stream()
                        .map(reader -> new ReaderDto(reader.getFullName(), reader.getEmail()))
                        .collect(Collectors.toList())
        );

        return dto;
    }
}