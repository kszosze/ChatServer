package com.chatapp.service;

import static com.chatapp.fixtures.RoomFixtures.newRoom;
import static com.chatapp.fixtures.RoomFixtures.otherRoom;
import static com.chatapp.fixtures.RoomFixtures.room;
import static com.chatapp.fixtures.UserFixtures.receiver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chatapp.ChatServerApplicationTests;
import com.chatapp.model.Room;

public class RoomServiceTest extends ChatServerApplicationTests {

	@Autowired
	private RoomService roomService;
	
	@Test
	public void save()
	{
		Room room = roomService.save(newRoom());
		assertThat(room,not(nullValue()));
		assertThat(room,hasProperty("id",is(3)));
	}
	
	@Test
	public void findAll()
	{
		assertThat(roomService.findAll(),not(empty()));
		assertThat(roomService.findAll(),hasSize(2));
		assertThat(roomService.findAll(),containsInAnyOrder(room(), otherRoom()));
	}

	@Test
	public void findAllByUser()
	{
		assertThat(roomService.findAllByUser(receiver()),not(empty()));
		assertThat(roomService.findAllByUser(receiver()),hasSize(2));
		assertThat(roomService.findAllByUser(receiver()),containsInAnyOrder(room(), otherRoom()));
	}

	@Test
	public void findByName()
	{
		assertNotNull(roomService.findByName(room().getName()));
	}
}
