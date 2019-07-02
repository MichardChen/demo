package com.etc.auth.annotation;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

	/**
	 * 登录密钥,这里写固定
	 */
	private String secretKey = "123456";

	/**
	 * 获取jwt发布时间
	 * @param token
	 * @return
	 */
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token).getIssuedAt();
	}

	/**
	 * 获取超时时间
	 * @param token
	 * @return
	 */
	public Date getExpireDateFromToken(String token) {
		return getClaimFromToken(token).getExpiration();
	}

	/**
	 * 获取接收者
	 * @param token
	 * @return
	 */
	public String getAudienceFromToken(String token){
		return getClaimFromToken(token).getAudience();
	}

	/**
	 * 获取jwt payload部分
	 * @param token
	 * @return
	 */
	public Claims getClaimFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
	}

	/**
	 * 从token中获取用户信息
	 * @param token
	 * @return
	 */
	public String getUserNameFromToken(String token){
		return getClaimFromToken(token).getSubject();
	}
}
