package com.example.bookstore.exception;

public class BookAlreadyExistExeption extends Exception {
    
        private static final long serialVersionUID = 1L;
    
        public BookAlreadyExistExeption(String message) {
            super(message);
        }
    
}
