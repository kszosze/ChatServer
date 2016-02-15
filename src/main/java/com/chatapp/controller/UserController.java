package com.chatapp.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chatapp.factory.UserFactory;
import com.chatapp.model.User;
import com.chatapp.service.UserService;


@Controller
@RequestMapping("/chatapp")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserFactory userFactory;
	
	@RequestMapping(path="/login/{username}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  String login(@PathVariable String username)
	{
		User user = userService.findByUserName(username);
		if (user == null)
		{
			user = userFactory.create(username, username);
		}
		user.setActive(true);
		userService.save(user);
		logger.info("User logged "+user.getUserName());
		return user.getUuid();
	}

	@RequestMapping(path="/logout/{uuid}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  String logout(@PathVariable String uuid)
	{
		User user = userService.findByUuid(uuid);
		if (user != null)
		{
			user.setActive(false);
			userService.save(user);
			logger.info("User log out "+user.getUserName());
		}
	
		return user.getUuid().toString();
	}
}
