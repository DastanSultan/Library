package com.example.Library.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    protected Author(){}
    public Author(String fullName, String email){
        this.fullName = fullName;
        this.email = email;
    }
    public void addBook(Book book){
        if (!books.contains(book)){
            books.add(book);
            if (book.getAuthor() != this){
                book.setAuthor(this);
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
