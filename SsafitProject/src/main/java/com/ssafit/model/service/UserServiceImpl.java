package com.ssafit.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	// 유저 이름 조회
	@Transactional
	@Override
	public String searchUserName(String userId) {
		return userDao.selectUserName(userId);
	}

	// 유저 타입 (manager/non-manager) 조회
	@Transactional
	@Override
	public boolean checkUserType(String userId) {
		return userDao.checkUserType(userId);
	}

	// 유저 조회
	@Transactional
	@Override
	public User search(String userId) {
		return userDao.select(userId);
	}

	// 로그인
	@Transactional
	@Override
	public boolean login(Map<String, String> map) {
		String userId = map.get("userId");
		String userPassword = map.get("userPassword");
		User user = userDao.select(userId);
		if (user == null) {
			return false;
		} 
		
		else if (!userId.equals(user.getUserId()) || !userPassword.equals(user.getUserPassword())) {
			return false;
		}
		// 로그인 -> 세션 추가
		return true;
	}

	// 로그아웃
	@Transactional
	@Override
	public boolean logout() {
		// if) 로그인 상태(세션정보확인) -> 세션 제거(invalidate)
		// else) ??
		return true;
	}

	// 회원가입
	@Transactional
	@Override
	public boolean signupUser(User user) {
		String userId = user.getUserId();
		if (userDao.select(userId) != null) {
			return false;
		} else {
			userDao.insertUser(user);
		}
		return true;
	}

	// 회원탈퇴
	@Transactional
	@Override
	public boolean deleteUser(Map<String, String> map) {
		String userId = map.get("userId");
		String userPassword = map.get("userPassword");
		User user = userDao.select(userId);
		if (user == null) {
			return false;
		} else if (!userPassword.equals(user.getUserPassword())) {
			return false;
		}
		userDao.deleteUser(userId, userPassword);
		return true;
	}

}
