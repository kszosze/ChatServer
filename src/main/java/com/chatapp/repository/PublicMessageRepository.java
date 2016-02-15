package com.chatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Message;
import com.chatapp.model.PublicMessage;
import com.chatapp.model.Room;
import com.chatapp.model.User;

/**
 * The Interface PublicMessageRepository.
 */
public interface PublicMessageRepository extends JpaRepository<PublicMessage, Integer> {

	/**
	 * Find all by room.
	 *
	 * @param room the room
	 * @return the list
	 */
	List<Message> findAllByRoom(Room room);

	/**
	 * Find all by sender and room.
	 *
	 * @param user the user
	 * @param room the room
	 * @return the list
	 */
	List<Message> findAllBySenderAndRoom(User user, Room room);
}
