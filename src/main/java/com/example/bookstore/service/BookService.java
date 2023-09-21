package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.model.Book;

public interface BookService {

    void createBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(long id);

    void deleteBook(long id);

    void updateBook(Long id, Book book);

    public List<Book> getRecentBooks();

    public long getBookCount();


}