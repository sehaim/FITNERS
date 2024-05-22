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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/ssafit")
@Tag(name = "Controller - User", description = "사용자 관련 기능")
@CrossOrigin
public class UserRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";
	private static final String NONE = "NONE";

	@Autowired
	private JwtUtil jwtUtil;

	private final UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@Operation(summary = "로그인", description = "유저 아이디와 패스워드를 입력하여 로그인")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED") })
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
		map.put("access-token", jwtUtil.createToken(user.getUserId()));

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Operation(summary = "로그아웃")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED") })
	@PostMapping("/logout")
	public ResponseEntity<String> logout() {
		boolean result = userService.logout();
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@Operation(summary = "회원가입", description = "유저 아이디와 패스워드, 이름, 유저 타입을 입력하여 회원가입")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "CREATED"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		boolean result = userService.signupUser(user);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

}
