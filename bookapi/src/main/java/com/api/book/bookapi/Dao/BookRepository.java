package com.api.book.bookapi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.bookapi.Entites.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public Book findById(int id);
}
