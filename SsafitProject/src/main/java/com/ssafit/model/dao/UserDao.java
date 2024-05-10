package com.ssafit.model.dao;

import com.ssafit.model.dto.User;

public interface UserDao {
	// 유저 이름 조회
	public String selectUserName(String userId);

	// 유저 타입 (manager/non-manager) 조회
	public boolean checkUserType(String userId);

	// 유저 조회
	public User select(String userId);

	// 회원가입
	public int insertUser(User user);

	// 회원탈퇴
	public int deleteUser(String userId, String userPassword);
}
