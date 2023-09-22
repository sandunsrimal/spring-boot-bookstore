package com.example.bookstore.service;

import java.util.List;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import com.example.bookstore.exception.BookAlreadyExistExeption;
import com.example.bookstore.model.FavoriteBook;

public interface FavoriteBookService {

    public void saveMyBooks(long bookid,OidcUser user) throws BookAlreadyExistExeption;

    List<FavoriteBook> getAllBooks(OidcUser user);

    public void removeFromFavorites(long id, OidcUser user);

    public long getFavoriteBookCount(OidcUser user);
}