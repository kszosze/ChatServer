package com.chatapp.fixtures;

import com.chatapp.model.Message;
import com.chatapp.model.PrivateMessage;
import com.chatapp.model.PublicMessage;

import static com.chatapp.fixtures.UserFixtures.receiver;
import static com.chatapp.fixtures.UserFixtures.user;

import com.chatapp.json.ChatMessage;

import static com.chatapp.fixtures.RoomFixtures.room;

public class MessageFixtures {

	public final static Message privateMessage()
	{
		PrivateMessage message = new PrivateMessage(user());
		message.setSender(receiver());
		return message;
	}
	
	public final static Message publicMessage()
	{
		PublicMessage message = new PublicMessage(room());
		message.setSender(receiver());
		return message;
	}

	public final static ChatMessage chatMessagePublic()
	{
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setContent("test message");
		chatMessage.setRoom("Off_Topic");
		chatMessage.setSender("jsmith");
		chatMessage.setToken("123654789");
		
		return chatMessage;
	}
	
	public final static ChatMessage chatMessagePrivate()
	{
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setContent("test message");
		chatMessage.setRoom("jsmith");
		chatMessage.setSender("jsmith");
		chatMessage.setToken("123654789");
		
		return chatMessage;
	}
	
	public final static ChatMessage chatMessagehack()
	{
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setContent("test message");
		chatMessage.setRoom("Off_Topic");
		chatMessage.setSender("jsmith");
		chatMessage.setToken("123456789");
		
		return chatMessage;
	}
}
