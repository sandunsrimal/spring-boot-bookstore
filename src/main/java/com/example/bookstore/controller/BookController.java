package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET all books
    @GetMapping
    public String getAllBooks(Model model, @AuthenticationPrincipal OidcUser user) {
        if (user != null) {
            model.addAttribute("user", user.getClaims());
        }
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("BookList", books);
        return "book-list";
    }

    // GET book by id
    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model, @AuthenticationPrincipal OidcUser user) {
        if (user != null) {
            model.addAttribute("user", user.getClaims());
        }
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-details";
    }

    // CREATE a new book
    @GetMapping("/new")
    public String createBookForm(Model model, @AuthenticationPrincipal OidcUser user) {
        if (user != null) {
            model.addAttribute("user", user.getClaims());
        }
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/api/v2/new")
    public String createBook(@ModelAttribute Book book) {
        bookService.createBook(book);
        return "redirect:/books";
    }

    // UPDATE an existing book
    @GetMapping("/api/v2/{id}/edit")
    public String updateBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-form";
    }

    @PostMapping("/api/v2/{id}/edit")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    // DELETE a book
    @GetMapping("/api/v2/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }   
}
