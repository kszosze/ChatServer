/**
 * 
 */
package com.chatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Message;
import com.chatapp.model.User;

/**
 * The Interface MessageRepository.
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

	/**
	 * Find all by sender.
	 *
	 * @param user the user
	 * @return the list
	 */
	List<Message> findAllBySender(User user);



}
