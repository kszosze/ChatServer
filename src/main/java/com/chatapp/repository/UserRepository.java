/**
 * 
 */
package com.chatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.User;

/**
 * The Interface UserRepository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Find all by name like.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<User> findAllByNameLike(String name);

	/**
	 * Find all by user name like.
	 *
	 * @param username the username
	 * @return the list
	 */
	List<User> findAllByUserNameLike(String username);

	/**
	 * Find all by active true.
	 *
	 * @return the list
	 */
	List<User> findAllByActiveTrue();

	/**
	 * Find all by active false.
	 *
	 * @return the list
	 */
	List<User> findAllByActiveFalse();

	/**
	 * Find by uuid.
	 *
	 * @param uuid the uuid
	 * @return the user
	 */
	User findByUuid(String uuid);

	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the user
	 */
	User findByUserName(String userName);

}
