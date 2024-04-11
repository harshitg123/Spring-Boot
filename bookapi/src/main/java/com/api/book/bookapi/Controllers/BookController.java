package com.api.book.bookapi.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookapi.Entites.Book;
import com.api.book.bookapi.Services.BookService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        // Book book = new Book(1, "Welcome to programming", "Harshit gupta");
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

}