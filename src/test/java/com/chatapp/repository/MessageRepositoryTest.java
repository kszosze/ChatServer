package com.chatapp.repository;

import static com.chatapp.fixtures.UserFixtures.user;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chatapp.ChatServerApplicationTests;

public class MessageRepositoryTest extends ChatServerApplicationTests {

	@Autowired
	private MessageRepository messageRepository;
	
   @Test
  public void findAllBySender() {    
    assertThat(messageRepository.findAllBySender(user()), is(not(empty())));
  }

}
