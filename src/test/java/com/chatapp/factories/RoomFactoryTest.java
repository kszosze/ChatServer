package com.chatapp.factories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chatapp.ChatServerApplicationTests;
import com.chatapp.factory.RoomFactory;
import com.chatapp.model.Room;

public class RoomFactoryTest  extends ChatServerApplicationTests  {
	
	@Autowired
	private RoomFactory roomFactory;
	
	@Test
	public void create()
	{
		Room room = roomFactory.create("testingRoom");
		assertThat(room, not(nullValue()));
		assertThat(room, hasProperty("id",is(3)));
	}
}
