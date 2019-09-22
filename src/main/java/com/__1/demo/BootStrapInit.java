package com.__1.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.tomcat.util.descriptor.web.ContextEjb;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import com.__1.demo.model.Author;
import com.__1.demo.model.Book;
import com.__1.demo.model.Publisher;
import com.__1.demo.repositories.AuthorRepository;
import com.__1.demo.repositories.BookRepository;
import com.__1.demo.repositories.PublisherRepository;

@Component
public class BootStrapInit implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRep;
	private BookRepository bookRep;
	private PublisherRepository publisherRep;
	
	public BootStrapInit(AuthorRepository authorRepository, BookRepository bookRepository
			, PublisherRepository publisherRepository) {
		
		
		this.bookRep = bookRepository;
		this.publisherRep = publisherRepository;
		this.authorRep =  authorRepository;
	}
	

	
	public void addData () {
		Book b1 = new Book();
		Book b2 = new Book();
		Publisher p1 = new Publisher("Wrox","yy 22 xx");
		Publisher p2 = new Publisher("Walt Desiny", "Biii 3");
		Author a1 = new Author("Gemi","Lary");
		Author a2 = new Author("Coline","XX");
		System.out.println(a1.getId() + "    <=======");
		b1.setTitle("GotoGo");
		b1.setIsbn("123789");
		
		b2.setTitle("World is Rounded");

		b2.setIsbn("453525342");
		
		b1.setPublisher(p1);
//		b2.setPublisher(p2);

		a1.getBooks().add(b1);
		a2.getBooks().add(b2);


		// I have to save author before add another one to book instance
		b1.getAuthors().add(a1);
		authorRep.save(a1);
		authorRep.save(a2);
		b1.getAuthors().add(a2);
		b2.getAuthors().add(a1);
		
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
