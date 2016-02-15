package com.chatapp.factories;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.chatapp.ChatServerApplicationTests;
import com.chatapp.factory.MessageFactory;
import com.chatapp.model.Message;
import com.chatapp.model.PrivateMessage;
import com.chatapp.model.PublicMessage;

import static com.chatapp.fixtures.MessageFixtures.chatMessagePublic;
import static com.chatapp.fixtures.MessageFixtures.chatMessagePrivate;
import static com.chatapp.fixtures.MessageFixtures.chatMessagehack;;
public class MessageFactoryTest  extends ChatServerApplicationTests  {

	@Autowired
	private MessageFactory messageFactory;
	
	@Rule
	public ExpectedException securityException = ExpectedException.none(); 
	
	@Test
	public void createPublic()
	{
		Message message = messageFactory.create(chatMessagePublic());
		
		assertNotNull(message);
		assertThat(message, instanceOf(PublicMessage.class));
	}
	
	@Test
	public void createPrivate()
	{
		Message message = messageFactory.create(chatMessagePrivate());
		
		assertNotNull(message);
		assertThat(message, instanceOf(PrivateMessage.class));
	}
	
	@Ignore("Ignore due not Security Implemented")
	public void createException()
	{
		securityException.expect(SecurityException.class);
		securityException.expectMessage("Message for not authorized user jsmith");
		
		Message message = messageFactory.create(chatMessagehack());
		
		assertNotNull(message);
		assertThat(message, instanceOf(PrivateMessage.class));
		
	}
}
