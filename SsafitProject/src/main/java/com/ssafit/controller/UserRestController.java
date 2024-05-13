package com.ssafit.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.User;
import com.ssafit.model.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/ssafit")
@Tag(name = "UserRestController", description = "User 관련 서비스/로그인, 로그아웃, 회원가입 API")
@CrossOrigin
public class UserRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";
	private static final String NONE = "NONE";

	private final UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		String userId = map.get("userId");
		String userPassword = map.get("userPassword");

//		System.out.println("session : " + session);
//		System.out.println("session[Id] : " + session.getId());

		Map<String, String> mapToService = new HashMap();
		mapToService.put("userId", userId);
		mapToService.put("userPassword", userPassword);
		boolean result = userService.login(mapToService);
		if (!result) {
			return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		String sessionId = UUID.randomUUID().toString();
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", userId);
		session.setMaxInactiveInterval(1800);

		Cookie cookie = new Cookie("sessionId", sessionId);
		response.addCookie(cookie);

		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 로그아웃
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();

		boolean result = userService.logout();
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		boolean result = userService.signupUser(user);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 회원탈퇴
	@DeleteMapping("/withdrawal")
	public ResponseEntity<?> Withdrawal(@RequestParam String userId, @RequestParam String userPassword) {
		Map<String, String> map = new HashMap();
		map.put("userId", userId);
		map.put("userPassword", userPassword);
		boolean result = userService.deleteUser(map);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

}
