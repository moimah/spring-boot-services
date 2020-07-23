package com.moimah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moimah.db.UserRepository;
import com.moimah.model.User;

/**
 * Contoller for users
 * @author moimah
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Get all users from database
	 * @return
	 */
	@GetMapping("/get")
	public List<User> getUsers() {
		return userRepository.findAll();
	}	
	
	/**
	 * Not in use, using JwtAuthenticationController saveUser
	 * @param user
	 */
	@Deprecated
	@PostMapping("/add")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	/**
	 * Delete an existing by id
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = { "/{id}" })
	public User deleteUser(@PathVariable("id") long id) {
		User user = userRepository.getOne(id);
		userRepository.deleteById(id);
		return user;
	}
	
	
	

}