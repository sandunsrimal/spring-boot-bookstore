package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.entity.User;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.UserService;
import com.example.bookstore.service.MyBookListService;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BookController {
    @Autowired
    private BookService service;

     @Autowired
    private UserService userservice;

     @Autowired
    private UserRepository userrepo;

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
        @GetMapping("/register")
    public String userRegister() {
        return "register";
    }
         @GetMapping("/login")
    public String Login() {
        return "login";
    }
    @GetMapping("/book_list")
    public ModelAndView getAllBooks() {
        List<Book> list = service.getAllBooks();
        // ModelAndView m= new ModelAndView();
        // m.setViewName("bookList");
        // m.addObject("book",list);
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/savebook")
    public String addBook(@ModelAttribute Book b) {
        service.savebook(b);
        return "redirect:/book_list";
    }

     @PostMapping("/saveuser")
    public String addUser(@ModelAttribute User b) {
        userservice.saveuser(b);
        return "redirect:/login";
    }

    @GetMapping("/userlogin")
    public String loginUser(@ModelAttribute("user") User user) {
       System.out.println(user.getUsername());
       System.out.println(user.getPassword());
       String username=user.getUsername();
       User userdata = userrepo.findByUsername(username);
       if(user.getPassword().equals(userdata.getPassword())){
        return "redirect:/book_list";
       }else{
        return "redirect:/login";
       }
        
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
