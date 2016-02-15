/*
 * 
 */
package com.chatapp.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chatapp.model.User;
import com.chatapp.service.UserService;

/**
 * A factory for creating User objects.
 */
@Component
public class UserFactory {

	/** The user service. */
	@Autowired
	private UserService userService;
	
	/**
	 * Creates the Use Object.
	 *
	 * @param name the name
	 * @param username the username
	 * @return the user
	 */
	public User create(String name, String username)
	{
		User user = userService.findByUserName(username);
		if (user == null)
		{
			user = new User(name, username);
		}
		userService.save(user);
		
		return user;
	}
}
