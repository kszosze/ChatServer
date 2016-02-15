/**
 * 
 */
package com.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Room;

/**
 * The Interface RoomRepository.
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {

	/**
	 * Find by name.
	 *
	 * @param room the room
	 * @return the room
	 */
	Room findByName(String room);

}
