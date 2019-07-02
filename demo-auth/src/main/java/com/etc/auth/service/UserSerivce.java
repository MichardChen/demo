package com.etc.auth.service;

import com.etc.auth.annotation.User;

public interface UserSerivce {

	User findUserById(String userId);

	User findByUsername(User user);
}
