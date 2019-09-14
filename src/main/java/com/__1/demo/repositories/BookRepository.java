<<<<<<< HEAD
package com.__1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.__1.demo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
=======
package com.__1.demo.repositories;

import com.__1.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
>>>>>>> jpa_start_with_branch_2
