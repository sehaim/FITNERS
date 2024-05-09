package com.ssafit.model.service;

import com.ssafit.model.dto.User;

public interface UserService {
	
	// 유저 이름 조회
	public String searchUserName(String id);

	// 유저 타입 (manager/non-manager) 조회
	public boolean checkUserType(String id);

	// 유저 조회
	public User search(String id);	

	// 로그인
	public boolean login(String id, String password);

	// 로그아웃
	public boolean logout();

	// 회원가입
	public boolean signupUser(User user);

	// 회원탈퇴
	public boolean deleteUser(String id, String password);
}
