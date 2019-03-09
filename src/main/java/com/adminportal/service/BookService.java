package com.adminportal.service;

import com.adminportal.domain.Book;

import java.util.List;

/**
 * The interface Book service.
 */
public interface BookService {

	/**
	 * Save book.
	 *
	 * @param book the book
	 * @return the book
	 */
	Book save(Book book);

	/**
	 * Find all list.
	 *
	 * @return the list
	 */
	List<Book> findAll();

	/**
	 * Find one book.
	 *
	 * @param id the id
	 * @return the book
	 */
	Book findOne(Long id);
}
