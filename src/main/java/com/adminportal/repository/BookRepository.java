package com.adminportal.repository;

import com.adminportal.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Book repository.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
