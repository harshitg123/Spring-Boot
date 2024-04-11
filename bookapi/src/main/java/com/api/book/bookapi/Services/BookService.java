package com.api.book.bookapi.Services;

import java.util.*;

import org.springframework.stereotype.Component;

import com.api.book.bookapi.Entites.Book;

@Component
public class BookService {

    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1, "Welcome to dependency hell", "Harshit Gupta"));
        books.add(new Book(2, "Welcome to spring boot 3", "XYZ"));
        books.add(new Book(3, "Welcome to java", "PQR"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public Book saveBook(Book book) {
        books.add(book);
        return book;
    }
}
