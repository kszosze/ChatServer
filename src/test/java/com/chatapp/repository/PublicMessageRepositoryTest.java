package com.chatapp.repository;

import static com.chatapp.fixtures.RoomFixtures.room;
import static com.chatapp.fixtures.UserFixtures.user;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chatapp.ChatServerApplicationTests;

public class PublicMessageRepositoryTest extends ChatServerApplicationTests {

	@Autowired
	private PublicMessageRepository messageRepository;
	
  @Test
  public void findAllByRoom() {

	  assertThat(messageRepository.findAllByRoom(room()), is(not(empty())));
	  assertThat(messageRepository.findAllByRoom(room()), hasSize(3));

  }

  @Test
  public void findAllBySenderAndRoom() {
	  assertThat(messageRepository.findAllBySenderAndRoom(user(),room()), is(not(empty())));
	  assertThat(messageRepository.findAllBySenderAndRoom(user(),room()), hasSize(2));
  }
}
