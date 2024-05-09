package com.ssafit.model.service;

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

	@Transactional
	@Override
	public String searchUserName(String id) {
		return userDao.selectUserName(id);
	}

	@Transactional
	@Override
	public boolean checkUserType(String id) {
		return userDao.checkUserType(id);
	}

	@Transactional
	@Override
	public User search(String id) {
		return userDao.select(id);
	}

	@Transactional
	@Override
	public boolean login(String id, String password) {
		return false;
	}

	@Transactional
	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean signupUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean deleteUser(String id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
