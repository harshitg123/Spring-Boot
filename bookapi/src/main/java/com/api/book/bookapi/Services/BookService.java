package com.api.book.bookapi.Services;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        Book book = null;
        try {
            book = books.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book saveBook(Book book) {
        books.add(book);
        return book;
    }

    public void deleteBook(int id) {
        books = books.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(int id, Book book) {
        books = books.stream().map(b -> {
            if (b.getId() == id) {
                b.setAuthor(book.getAuthor());
                b.setName(book.getName());
                return b;
            }
            return b;
        }).collect(Collectors.toList());
    }
}
