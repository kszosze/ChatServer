package com.chatapp.repository;

import static com.chatapp.fixtures.UserFixtures.receiver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chatapp.ChatServerApplicationTests;

public class PrivateMessageRepositoryTest extends ChatServerApplicationTests {

	@Autowired
	private PrivateMessageRepository messageRepository;
	
  @Test
  public void findAllByReceiver() {
	  assertThat(messageRepository.findAllByReceiver(receiver()), is(not(empty())));
	  assertThat(messageRepository.findAllByReceiver(receiver()), contains(
			    hasProperty("receiver", is(receiver()))));
  }
}
