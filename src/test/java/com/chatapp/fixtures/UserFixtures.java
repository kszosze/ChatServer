package com.chatapp.fixtures;

import com.chatapp.model.User;

public class UserFixtures {

	public static User user()
	{
		final User user = new User("John Smith","jsmith");
		user.setId(1);
		return user;
	}

	public static User receiver()
	{
		final User user = new User("Kevin Smith","ksmith");
		user.setId(2);
		return user;
	}
	
	public static User newUser()
	{
		final User user = new User("John Connor","jconnor");

		return user;
	}
}
