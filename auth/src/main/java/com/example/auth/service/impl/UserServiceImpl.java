package com.example.auth.service.impl;

import org.springframework.stereotype.Service;

import com.example.auth.annotation.User;
import com.example.auth.service.UserSerivce;

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
