package com.example.bookstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.FavoriteBookService;

@Controller
@RequestMapping("/favorites")
public class FavBookController {

    @Autowired
    private FavoriteBookService favoriteBookService;

    @Autowired
    private BookService bookService;

    // GET all books
    @GetMapping
    public String getAllBooks(Model model, @AuthenticationPrincipal OidcUser user) {
        if (user != null) {
            model.addAttribute("user", user.getClaims());
        }
        List<Book> bookList = favoriteBookService.getAllBooks(user)
                .stream()
                .map(favoriteBook -> bookService.getBookById(favoriteBook.getBookid()))
                .collect(Collectors.toList());
        model.addAttribute("BookList", bookList);
        return "fav-book-list";
    }

    @GetMapping("/api/v2/new/{id}")
    public ResponseEntity<String> createBook(@PathVariable Long id, @AuthenticationPrincipal OidcUser user) {
        if (user != null) {
            try {
                favoriteBookService.saveMyBooks(id, user);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
        return ResponseEntity.ok("Book added to favorites");
    }

    // DELETE a book
    @GetMapping("/api/v2/{id}/delete")
    public String deleteBook(@PathVariable Long id, @AuthenticationPrincipal OidcUser user) {
        if (user != null) {
            favoriteBookService.removeFromFavorites(id, user);
        }
        return "redirect:/favorites";
    }
}
