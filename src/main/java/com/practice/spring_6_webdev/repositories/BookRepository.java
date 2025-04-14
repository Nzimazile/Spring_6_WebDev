package com.practice.spring_6_webdev.repositories;

import com.practice.spring_6_webdev.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
