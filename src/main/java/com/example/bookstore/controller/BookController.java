package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.MyBookListService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private MyBookListService myBookService;
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }
    @GetMapping("/book_list")
    public ModelAndView getAllBooks() {
        List<Book> list = service.getAllBooks();
        // ModelAndView m= new ModelAndView();
        // m.setViewName("bookList");
        // m.addObject("book",list);
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/book_list";
    }

    @GetMapping("/my_book_list")
    public String getMyBookList() {
        return "myBookList";
        
    }
    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBookList mb= new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect://my_book_list";
    }
    
}
