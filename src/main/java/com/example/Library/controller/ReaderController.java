package com.example.Library.controller;

import com.example.Library.dto.request.ReaderCreateDto;
import com.example.Library.dto.response.BookDto;
import com.example.Library.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderController{
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService){
        this.readerService = readerService;
    }

    @PostMapping
    public void readerCreate(@Valid @RequestBody ReaderCreateDto readerCreateDto){
        readerService.readerCreate(readerCreateDto);
    }

    @PostMapping("/{readerId}/books/{bookId}")
    public void addBook(@PathVariable Long readerId, @PathVariable Long bookId){
        readerService.addBook(readerId, bookId);
    }

    @GetMapping("/{id}")
    public List<BookDto> readerDtoList(@PathVariable Long id){
        return readerService.getAll(id);
    }
}
