package com.practice.spring_6_webdev.services;

import com.practice.spring_6_webdev.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
