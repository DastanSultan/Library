package com.example.Library.controller;

import com.example.Library.dto.request.BookCreateDto;
import com.example.Library.dto.response.BookDto;
import com.example.Library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController{
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public void createBook(@Valid @RequestBody BookCreateDto bookCreateDto){
         bookService.createBook(bookCreateDto);
    }

    @PostMapping("/{bookId}/authors/{authorId}")
    public void setAuthor(@PathVariable Long authorId, @PathVariable Long bookId){
        bookService.setAuthor(authorId, bookId);
    }

    @PostMapping("/{bookId}/readers/{readerId}")
    public void addReader(@PathVariable Long bookId, @PathVariable Long readerId){
        bookService.addReader(bookId, readerId);
    }

    @GetMapping("/{id}")
    public List<BookDto> readerDtoList(@PathVariable Long id){
        return bookService.readerDtoList(id);
    }
}
