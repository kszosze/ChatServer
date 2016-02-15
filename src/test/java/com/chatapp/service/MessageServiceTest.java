package com.chatapp.service;

import static com.chatapp.fixtures.MessageFixtures.privateMessage;
import static com.chatapp.fixtures.RoomFixtures.room;
import static com.chatapp.fixtures.UserFixtures.user;
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
import com.chatapp.model.Message;

public class MessageServiceTest extends ChatServerApplicationTests {

	@Autowired
	private MessageService messageService;
	
	@Test
	public void saveTest()
	{
		Message message = messageService.save(privateMessage()); 
		assertThat(message,not(nullValue()));
		assertThat(message,hasProperty("id",is(6)));
	}
	
	@Test
	public void findAllMessagesByUser()
	{
		assertThat(messageService.findAllMessagesByUser(user()), is(not(empty())));
		assertThat(messageService.findAllMessagesByUser(user()), hasSize(3));
	}
	
	@Test
	public void findAllMessagesByRoom()
	{
		  assertThat(messageService.findAllMessagesByRoom(room()), is(not(empty())));
		  assertThat(messageService.findAllMessagesByRoom(room()), hasSize(3));
	}
	
	@Test
	public void findAllMessageByUserAndRoom()
	{
		  assertThat(messageService.findAllMessageByUserAndRoom(user(), room()), is(not(empty())));
		  assertThat(messageService.findAllMessageByUserAndRoom(user(), room()), hasSize(2));
	}
	
	
}
