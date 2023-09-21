package com.example.bookstore.model;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FavoriteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookid;

    private String userid;

    public FavoriteBook() {
    }

    public FavoriteBook(long bookId, String userId) {
        this.bookid = bookId;
        this.userid = userId;
    }

    public FavoriteBook(Book book, OidcUser user) {
        this.bookid = book.getId();
        this.userid = user.getUserInfo().getSubject();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    

}