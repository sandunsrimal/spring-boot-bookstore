package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.repository.MyBookRepository;



@Service
public class MyBookListService {
    
    @Autowired
    private MyBookRepository mybook;
    public void saveMyBooks(MyBookList book) {
        mybook.save(book);
    }
    public List<MyBookList> getAllBooks() {
        return null;
    }
}
