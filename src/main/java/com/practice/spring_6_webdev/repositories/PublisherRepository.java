package com.practice.spring_6_webdev.repositories;

import com.practice.spring_6_webdev.domain.Author;
import com.practice.spring_6_webdev.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
