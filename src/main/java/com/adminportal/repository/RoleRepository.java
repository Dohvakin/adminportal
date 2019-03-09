package com.adminportal.repository;

import com.adminportal.domain.security.Role;
import org.springframework.data.repository.CrudRepository;


/**
 * The interface Role repository.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
	/**
	 * Find byname role.
	 *
	 * @param name the name
	 * @return the role
	 */
	Role findByname(String name);
}
