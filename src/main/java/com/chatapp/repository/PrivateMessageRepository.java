package com.chatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Message;
import com.chatapp.model.PrivateMessage;
import com.chatapp.model.User;

/**
 * The Interface PrivateMessageRepository.
 */
public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Integer> {

	/**
	 * Find all by receiver.
	 *
	 * @param receiver the receiver
	 * @return the list
	 */
	List<Message> findAllByReceiver(User receiver);

	/**
	 * Find all by sender and receiver.
	 *
	 * @param user the user
	 * @param receiver the receiver
	 * @return the list
	 */
	List<Message> findAllBySenderAndReceiver(User user, User receiver);
}
