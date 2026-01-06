package com.example.Library.service;

import com.example.Library.dto.request.ReaderCreateDto;
import com.example.Library.dto.response.BookDto;
import com.example.Library.exception.consum.ResourseNotFoundException;
import com.example.Library.mapper.BookMapper;
import com.example.Library.model.Book;
import com.example.Library.model.Reader;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.ReaderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReaderService{
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    public ReaderService(ReaderRepository readerRepository, BookRepository bookRepository){
        this.readerRepository = readerRepository;
        this.bookRepository = bookRepository;
    }
    public Long readerCreate(ReaderCreateDto readerCreateDto){
        Reader reader = new Reader(readerCreateDto.getFullName(), readerCreateDto.getEmail());
        readerRepository.save(reader);
        return reader.getId();
    }
    public Long addBook(Long readerId, Long bookId){
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        reader.addBook(book);
        return book.getId();
    }
    public List<BookDto> getAll (Long readerId){
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourseNotFoundException("Reader not found"));
        return reader.getBooks()
                .stream()
                .map(BookMapper::bookDto)
                .toList();
    }
}
