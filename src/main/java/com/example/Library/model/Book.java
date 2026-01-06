package com.example.Library.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String isbn;
    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
    @JoinTable(name = "book_reader",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "reader_id"))
    private List<Reader> readers = new ArrayList<>();

    protected Book(){}
    public Book(String title, String isbn, double price){
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public void setAuthor(Author author){
        this.author = author;
        if (!author.getBooks().contains(this)){
            author.addBook(this);
        }
    }

    public void addReader(Reader reader){
        if (!readers.contains(reader)){
            readers.add(reader);
            if (!reader.getBooks().contains(this)){
                reader.addBook(this);
            }
        }
    }

    public Long getId( ){
        return id;
    }

    public String getTitle( ){
        return title;
    }

    public String getIsbn( ){
        return isbn;
    }

    public double getPrice( ){
        return price;
    }

    public Author getAuthor( ){
        return author;
    }

    public List<Reader> getReaders( ){
        return readers;
    }
}
