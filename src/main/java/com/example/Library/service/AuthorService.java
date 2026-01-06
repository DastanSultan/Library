package com.example.Library.service;

import com.example.Library.dto.request.AuthorCreateDto;
import com.example.Library.dto.response.BookDto;
import com.example.Library.exception.consum.ResourseNotFoundException;
import com.example.Library.mapper.BookMapper;
import com.example.Library.model.Author;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthorService{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Long createAuthor(AuthorCreateDto authorCreateDto){
        Author author = new Author(authorCreateDto.getFullName(), authorCreateDto.getEmail());
        authorRepository.save(author);
        return author.getId();
    }
    public List<BookDto> getBookByAuthorId(Long authorId){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourseNotFoundException("Author not found"));
        return author.getBooks()
                .stream()
                .map(BookMapper::bookDto)
                .toList();
    }
}
