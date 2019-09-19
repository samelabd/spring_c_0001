package com.__1.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.__1.demo.model.Author;
import com.__1.demo.model.Book;
import com.__1.demo.model.Publisher;
import com.__1.demo.repositories.AuthorRepository;
import com.__1.demo.repositories.BookRepository;
import com.__1.demo.repositories.PublisherRepository;

@Component
public class BootStrapInit implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRep;
	private BookRepository bookRep;
	private PublisherRepository publisherRep;

	public BootStrapInit(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {

		this.bookRep = bookRepository;
		this.publisherRep = publisherRepository;
		this.authorRep = authorRepository;
	}

	public void addData() {
		Book b1 = new Book("GotoGo", "123789");
		Book b2 = new Book("World is Rounded", "453525342");

		Publisher p1 = new Publisher("Wrox", "yy 22 xx");
		Publisher p2 = new Publisher("Walt Desiny", "Biii 3");

		Author a1 = new Author("Gemi", "Lary");
		Author a2 = new Author("Coline", "XX");

		b1.setPublisher(p1);
		b2.setPublisher(p2);

		b2.getAuthors().add(a2);
		a2.getBooks().add(b2);
		b1.getAuthors().add(a1);
		b1.getAuthors().add(a2);
		// Error happen when i tried to add additional Author to Book instance
		// I Think ManyToMany Relationship not working i understand
		authorRep.save(a1);
		authorRep.save(a2);

		publisherRep.save(p1);
		publisherRep.save(p2);
		bookRep.save(b1);
		bookRep.save(b2);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		addData();
	}

}
