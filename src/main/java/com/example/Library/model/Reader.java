package com.example.Library.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Reader{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;

    @ManyToMany(mappedBy = "readers")
    private List<Book> books = new ArrayList<>();

    protected Reader(){}

    public Reader(String fullName, String email){
        this.fullName = fullName;
        this.email = email;
    }
    public void addBook(Book book){
        if (!books.contains(book)){
            books.add(book);
            if (!book.getReaders().contains(this)){
                book.addReader(this);
            }
        }
    }

    public Long getId( ){
        return id;
    }

    public String getFullName( ){
        return fullName;
    }

    public String getEmail( ){
        return email;
    }

    public List<Book> getBooks( ){
        return books;
    }
}
