package com.etc.auth.annotation;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
@Component
public class JWTUtil {

	public String getToken(User user){
		String token = JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}
}
