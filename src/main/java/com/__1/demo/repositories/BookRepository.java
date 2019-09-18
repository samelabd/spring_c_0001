package com.__1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.__1.demo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
