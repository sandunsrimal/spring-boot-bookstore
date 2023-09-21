package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.bookstore.exeption.BookAlreadyExistExeption;
import com.example.bookstore.model.FavoriteBook;
import com.example.bookstore.repository.FavoriteBookRepository;

@Service
public class FavoriteBookServiceImpl implements FavoriteBookService {

    @Autowired
    private FavoriteBookRepository repo;

    @Override
    public void saveMyBooks(long bookid, OidcUser user) throws BookAlreadyExistExeption {
        if (user == null) {
            return;
        }
        String userId = user.getUserInfo().getSubject();

        if (repo.findByBookidAndUserid(bookid, userId) != null) {
            throw new BookAlreadyExistExeption("Book already added to favorites");
        }
        FavoriteBook favBook = new FavoriteBook(bookid, userId);
        repo.save(favBook);

    }

    @Override
    public List<FavoriteBook> getAllBooks(OidcUser user) {
        if (user == null) {
            return null;
        }
        return repo.findByUserid(user.getUserInfo().getSubject());
    }

    @Override
    public void removeFromFavorites(long id, OidcUser user) {
        if (user == null) {
            return;
        }
        String userId = user.getUserInfo().getSubject();
        FavoriteBook favBook = repo.findByBookidAndUserid(id, userId);
        if (favBook != null) {
            repo.delete(favBook);
        }
    }

    @Override
    public long getFavoriteBookCount(OidcUser user) {
        if (user == null) {
            return 0;
        } else {
            return repo.countByUserid(user.getUserInfo().getSubject());
        }

    }

}
