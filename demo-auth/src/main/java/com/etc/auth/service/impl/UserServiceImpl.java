package com.etc.auth.service.impl;

import com.etc.auth.annotation.User;
import org.springframework.stereotype.Service;

import com.etc.auth.service.UserSerivce;

@Service
public class UserServiceImpl implements UserSerivce{

	@Override
	public User findUserById(String userId) {
		User user = new User();
		user.setId("1");
		user.setUsername("admin");
		user.setPassword("admin");
		return user;
	}

	@Override
	public User findByUsername(User user) {
		User u = new User();
		u.setId("1");
		u.setUsername("admin");
		u.setPassword("admin");
		return u;
	}

}
