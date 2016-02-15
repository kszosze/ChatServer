package com.chatapp.service;

import static com.chatapp.fixtures.UserFixtures.newUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chatapp.ChatServerApplicationTests;
import com.chatapp.model.User;

public class UserServiceTest extends ChatServerApplicationTests {

	@Autowired
	private UserService userService;
	
	@Test
	public void save()
	{
		User user = userService.save(newUser());
		assertNotNull(user);
		assertThat(user, hasProperty("id", is(4)));
	}
	
	@Test
	public void findByUuid()
	{
		assertNotNull(userService.findByUuid("123654789"));
		assertThat(userService.findByUuid("123654789"),hasProperty("name",is("John Smith")));
	}
	
	@Test
	public void findAllActiveUser()
	{
		assertThat(userService.findAllActiveUser(),not(empty()));
		assertThat(userService.findAllActiveUser(),hasSize(3));
	}
	
	@Test
	public void findAllInactiveUser()
	{
		assertThat(userService.findAllInactiveUser(),is(empty()));
	}

	@Test
	public void findByUserName()
	{
		assertNotNull(userService.findByUserName("kconnor"));
		assertThat(userService.findByUserName("kconnor"),hasProperty("name",is("Kevin Connor")));
		assertThat(userService.findByUserName("kconnor"),hasProperty("id",is(3)));
	}
}
