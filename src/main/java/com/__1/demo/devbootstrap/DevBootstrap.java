package com.__1.demo.devbootstrap;

import com.__1.demo.model.Author;
import com.__1.demo.model.Book;
import com.__1.demo.repositories.AuthorRepository;
import com.__1.demo.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // create 2 repositories a- for book b- for author to store instance of both types into db
    AuthorRepository ar;
    BookRepository br;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Book b1 = new Book("Domain Driven", "8888-777-2222", "Human Bean");

        Author a1 = new Author("Hashim", "Elabd");

        b1.getAuthors().add(a1);

        a1.getBooks().add(b1);


        Book b2 = new Book("Back to Back", "2222-33333-4444", "Whatever");

        Author a2 = new Author("Ahmed", "Elabd");

        b2.getAuthors().add(a2);

        a2.getBooks().add(b2);
//        br.save(b1);
//        br.save(b2);


//        ar.save(a1);
//        ar.save(a2);

    }


}
