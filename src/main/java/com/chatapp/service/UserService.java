package com.chatapp.service;

import java.util.List;

import com.chatapp.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Save.
	 *
	 * @param user the user
	 * @return the user
	 */
	User save(User user);
	
	/**
	 * Find by uuid.
	 *
	 * @param uuid the uuid
	 * @return the user
	 */
	User findByUuid(String uuid);
	
	/**
	 * Find all active user.
	 *
	 * @return the list
	 */
	List<User> findAllActiveUser();
	
	/**
	 * Find all inactive user.
	 *
	 * @return the list
	 */
	List<User> findAllInactiveUser();

	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the user
	 */
	User findByUserName(String userName);
}
