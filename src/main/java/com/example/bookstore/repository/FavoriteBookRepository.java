package com.example.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.FavoriteBook;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Long> {
    long countByUserid(String userid);
    List<FavoriteBook> findByUserid(String userid);
    FavoriteBook findByBookidAndUserid(long id, String userId);
}
