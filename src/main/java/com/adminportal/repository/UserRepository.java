package com.adminportal.repository;

import com.adminportal.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<User, Long> {
	/**
	 * Find by username user.
	 *
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(String username);
}
