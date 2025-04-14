package com.practice.spring_6_webdev.bootstrap;

import com.practice.spring_6_webdev.domain.Author;
import com.practice.spring_6_webdev.domain.Book;
import com.practice.spring_6_webdev.domain.Publisher;
import com.practice.spring_6_webdev.repositories.AuthorRepository;
import com.practice.spring_6_webdev.repositories.BookRepository;
import com.practice.spring_6_webdev.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("987654321");

        Publisher IMDB = new Publisher();
        IMDB.setPublisherName("IMDB");
        IMDB.setAddress("8 Touring Road");
        IMDB.setCity("Manhattan");
        IMDB.setState("New York");
        IMDB.setZip("2598");

        Publisher IMDBSaved = publisherRepository.save(IMDB);

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        IMDBSaved.getBooks().add(noEJBSaved);
        IMDBSaved.getBooks().add(dddSaved);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.setPublisher(IMDBSaved);
        noEJBSaved.setPublisher(IMDBSaved);

        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);


        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);
        publisherRepository.save(IMDBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
