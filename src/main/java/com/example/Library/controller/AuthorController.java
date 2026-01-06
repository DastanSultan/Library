package com.example.Library.controller;

import com.example.Library.dto.request.AuthorCreateDto;
import com.example.Library.dto.response.BookDto;
import com.example.Library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController{

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping
    public void createAuthor(@Valid @RequestBody AuthorCreateDto authorCreateDto){
        authorService.createAuthor(authorCreateDto);
    }
    @GetMapping("/{id}")
    public List<BookDto> getAuthorById(@PathVariable Long id){
        return authorService.getBookByAuthorId(id);
    }
}
