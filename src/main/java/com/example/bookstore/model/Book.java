package com.example.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String category;
    private String language;
    private int pages;
    private double price;
    private String format;
    private String edition;
    private String description;
    private String imageUrl;

    public Book() {
    }

    public Book(String title, String author, String publisher, String isbn, String category, String language, int pages,
            double price, String format, String edition, String description, String imageUrl) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.category = category;
        this.language = language;
        this.pages = pages;
        this.price = price;
        this.format = format;
        this.edition = edition;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Book(Long id, String title, String author, String publisher, String isbn, String category, String language,
            int pages, double price, String format, String edition, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.category = category;
        this.language = language;
        this.pages = pages;
        this.price = price;
        this.format = format;
        this.edition = edition;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", isbn="
                + isbn + ", category=" + category + ", language=" + language + ", pages=" + pages + ", price=" + price
                + ", format=" + format + ", edition=" + edition + ", description=" + description + ", imageUrl="
                + imageUrl + "]";
    }

    
}
