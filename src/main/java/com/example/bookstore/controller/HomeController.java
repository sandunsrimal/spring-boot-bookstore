package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bookstore.service.BookService;
import com.example.bookstore.service.FavoriteBookService;

/**
 * Controller for the home page.
 */
@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private FavoriteBookService favBookService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser user) {
        if (user != null) {
            model.addAttribute("user", user.getClaims());
        }
        model.addAttribute("totalBooks", bookService.getBookCount());
        model.addAttribute("totalFavBooks", favBookService.getFavoriteBookCount(user));
        model.addAttribute("recentBooks", bookService.getRecentBooks());
        return "index";
    }
}
