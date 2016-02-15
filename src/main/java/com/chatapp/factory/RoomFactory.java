package com.chatapp.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chatapp.model.Room;
import com.chatapp.service.RoomService;

/**
 * A factory for creating Room objects.
 */
@Component
public class RoomFactory {

	/** The room service. */
	@Autowired
	private RoomService roomService;
	
	/**
	 * Creates the Room.
	 *
	 * @param roomName the room name
	 * @return the room
	 */
	public Room create(String roomName)
	{		
		Room room = roomService.findByName(roomName); 
		if (room == null)
		{
			room = new Room(roomName);
		}
		roomService.save(room);
		return room;
	}

}
