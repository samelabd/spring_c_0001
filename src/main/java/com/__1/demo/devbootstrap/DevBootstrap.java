package com.__1.demo.devbootstrap;

import com.__1.demo.model.Author;
import com.__1.demo.model.Book;
import com.__1.demo.model.Publisher;
import com.__1.demo.repositories.AuthorRepository;
import com.__1.demo.repositories.BookRepository;
import com.__1.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    /* create 2 repositories a- for book b- for author to store instance of both types into db*/
    AuthorRepository ar;
    BookRepository br;
    PublisherRepository pr;

    DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.ar = authorRepository;
        this.br = bookRepository;
        this.pr = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Book b1 = new Book("Domain Driven", "8888-777-2222");
        Publisher p1 = new Publisher("Human Bean", "xyz 22");
        Author a1 = new Author("Hashim", "Elabd");

        b1.setPublisher(p1);
        b1.getAuthors().add(a1);
        a1.getBooks().add(b1);

        pr.save(p1);
        ar.save(a1);
        br.save(b1);

        Book b2 = new Book("Back to Back", "2222-33333-4444");
        Author a2 = new Author("Ahmed", "Elabd");
        Publisher p2 = new Publisher("Whatever", "yyy iii 234");

        b2.getAuthors().add(a2);
        b2.setPublisher(p2);
        a2.getBooks().add(b2);

        pr.save(p2);
        ar.save(a2);
        br.save(b2);/*        br.save(b1); br.save(b2);*//*        ar.save(a1); ar.save(a2);*/
    }
}