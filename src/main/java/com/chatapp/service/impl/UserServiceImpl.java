/*
 * 
 */
package com.chatapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.model.User;
import com.chatapp.repository.UserRepository;
import com.chatapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	
	
	/* (non-Javadoc)
	 * @see com.chatapp.service.UserService#finByUuid(java.lang.String)
	 */
	@Override
	public User findByUuid(String uuid) {
		return userRepository.findByUuid(uuid);
	}



	@Override
	public List<User> findAllActiveUser() {
		return userRepository.findAllByActiveTrue();
	}

	@Override
	public List<User> findAllInactiveUser() {
		return userRepository.findAllByActiveFalse();
	}



	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
