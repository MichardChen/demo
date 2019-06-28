package com.example.auth.service;

import com.example.auth.annotation.User;

public interface UserSerivce {

	User findUserById(String userId);

	User findByUsername(User user);
}
