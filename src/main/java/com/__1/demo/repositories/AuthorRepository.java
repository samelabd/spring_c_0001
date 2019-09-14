<<<<<<< HEAD
package com.__1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.__1.demo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
=======
package com.__1.demo.repositories;

import com.__1.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
>>>>>>> jpa_start_with_branch_2
