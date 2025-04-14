package com.practice.spring_6_webdev.services;


import com.practice.spring_6_webdev.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
