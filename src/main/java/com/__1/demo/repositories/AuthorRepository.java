package com.__1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.__1.demo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
