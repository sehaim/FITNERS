package com.ssafit.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private String key = "SSAFIT_PROJECT_JWT_KEY";
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

	public String createToken(String id) {
		Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 60); // 1시간
		return Jwts.builder().header().add("typ", "JWT").and().claim("id", id).expiration(exp).signWith(secretKey)
				.compact();
	}

	// 실제로 확인하려고 하는 용도가 아니고 유효기간이 지났다면 알아서 에러를 발생시키려고 함.
	public Jws<Claims> validate(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}

}
