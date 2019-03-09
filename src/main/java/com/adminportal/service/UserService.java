package com.adminportal.service;

import com.adminportal.domain.User;
import com.adminportal.domain.security.UserRole;

import java.util.Set;


/**
 * The interface User service.
 */
public interface UserService {
	/**
	 * Create user user.
	 *
	 * @param user      the user
	 * @param userRoles the user roles
	 * @return the user
	 * @throws Exception the exception
	 */
	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user
	 */
	User save(User user);
}
