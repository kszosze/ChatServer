package com.chatapp.service;

import java.util.List;

import com.chatapp.model.Message;
import com.chatapp.model.Room;
import com.chatapp.model.User;

/**
 * The Interface MessageService.
 */
public interface MessageService {

	/**
	 * Save.
	 *
	 * @param message the message
	 * @return the message
	 */
	Message save(Message message);
	
	/**
	 * Find all messages by user.
	 *
	 * @param user the user
	 * @return the list
	 */
	List<Message> findAllMessagesByUser(User user);
	
	/**
	 * Find all messages by room.
	 *
	 * @param room the room
	 * @return the list
	 */
	List<Message> findAllMessagesByRoom(Room room);
	
	/**
	 * Find all message by user and room.
	 *
	 * @param user the user
	 * @param room the room
	 * @return the list
	 */
	List<Message> findAllMessageByUserAndRoom(User user, Room room);
	
	
}
