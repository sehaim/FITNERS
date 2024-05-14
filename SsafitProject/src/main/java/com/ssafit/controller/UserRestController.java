package com.ssafit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.LoginForm;
import com.ssafit.model.dto.User;
import com.ssafit.model.service.UserService;
import com.ssafit.util.JwtUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/ssafit")
@Tag(name = "UserRestController", description = "User 관련 서비스/로그인, 로그아웃, 회원가입 API")
@CrossOrigin
public class UserRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";
	private static final String NONE = "NONE";

//	@Autowired
//	private JwtUtil jwtUtil;

	private final UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginForm loginForm) {
		boolean result = userService.login(loginForm);
		if (!result) {
			Map<String, Object> map = new HashMap<>();
			map.put("result", FAIL);
			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("result", SUCCESS);

		User user = userService.search(loginForm.getUserId());
		map.put("userId", user.getUserId());
		map.put("userName", user.getUserName());
		map.put("isManager", user.isManager());

		// JWT 정보
//		map.put("access-token", jwtUtil.createToken(user.getUserId()));

		return new ResponseEntity<>(map, HttpStatus.OK);
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
		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

	// 회원탈퇴
	@DeleteMapping("/withdrawal")
	public ResponseEntity<?> Withdrawal(@RequestBody LoginForm loginForm) {
		boolean result = userService.deleteUser(loginForm);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

}
