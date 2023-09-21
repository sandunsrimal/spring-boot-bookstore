package com.example.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repo;

    @Override
    public void createBook(Book book) {
        repo.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteBook(long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());
        existingBook.setCategory(book.getCategory());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setPages(book.getPages());
        existingBook.setFormat(book.getFormat());
        existingBook.setEdition(book.getEdition());
        existingBook.setDescription(book.getDescription());
        existingBook.setImageUrl(book.getImageUrl());

        repo.save(existingBook);
    }

    @Override
    public List<Book> getRecentBooks() {
        return repo.findFirst3ByOrderByIdDesc();
    }

    @Override
    public long getBookCount() {
        return repo.count();
    }
}
