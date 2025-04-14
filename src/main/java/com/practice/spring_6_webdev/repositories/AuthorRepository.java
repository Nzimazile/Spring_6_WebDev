package com.practice.spring_6_webdev.repositories;

import com.practice.spring_6_webdev.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
