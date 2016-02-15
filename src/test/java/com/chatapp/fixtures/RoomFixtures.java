package com.chatapp.fixtures;

import com.chatapp.model.Room;

public class RoomFixtures {

	public final static Room room()
	{
		final Room room = new Room("public"); 
		room.setId(1);
		return room;
	}
	
	public final static Room otherRoom()
	{
		final Room room = new Room("topics"); 
		room.setId(2);
		return room;
	}
	
	
	public final static Room newRoom()
	{
		final Room room = new Room("party"); 
		return room;
	}
}
