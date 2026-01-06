package com.example.Library.service;

import com.example.Library.dto.request.BookCreateDto;
import com.example.Library.dto.response.BookDto;
import com.example.Library.exception.consum.ResourseNotFoundException;
import com.example.Library.mapper.BookMapper;
import com.example.Library.model.Author;
import com.example.Library.model.Book;
import com.example.Library.model.Reader;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.ReaderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ReaderRepository readerRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, ReaderRepository readerRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.readerRepository = readerRepository;
    }
    public Long createBook(BookCreateDto bookCreateDto){
        Book book = new Book(bookCreateDto.getTitle(), bookCreateDto.getIsbn(), bookCreateDto.getPrice());
        bookRepository.save(book);
        return book.getId();
    }
    public void setAuthor(Long authorId, Long bookId){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setAuthor(author);
    }

    public Long addReader(Long bookId, Long readerId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
        book.addReader(reader);
        return reader.getId();
    }

    public List<BookDto> readerDtoList(Long readerId){
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourseNotFoundException("Reader not found"));
        return reader.getBooks()
                .stream()
                .map(BookMapper::bookDto)
                .toList();
    }
}
