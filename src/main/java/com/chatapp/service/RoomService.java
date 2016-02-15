package com.chatapp.service;

import java.util.List;

import com.chatapp.model.Room;
import com.chatapp.model.User;

/**
 * The Interface RoomService.
 */
public interface RoomService {

	/**
	 * Save.
	 *
	 * @param room the room
	 * @return the room
	 */
	Room save(Room room);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Room> findAll();

	/**
	 * Find all by user.
	 *
	 * @param user the user
	 * @return the list
	 */
	List<Room> findAllByUser(User user);

	/**
	 * Find by name.
	 *
	 * @param room the room
	 * @return the room
	 */
	Room findByName(String room);
}
