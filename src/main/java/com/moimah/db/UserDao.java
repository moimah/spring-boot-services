package com.moimah.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moimah.model.User;

/**
 * Generic interface for crud operations
 * @author moimah
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	/**
	 * Find user from username
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	
}