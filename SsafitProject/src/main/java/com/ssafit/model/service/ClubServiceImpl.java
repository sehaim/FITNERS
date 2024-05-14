package com.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafit.model.dao.ClubDao;
import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.Club;

@Service
public class ClubServiceImpl implements ClubService {

	private final ClubDao clubDao;

	public ClubServiceImpl(ClubDao clubDao) {
		this.clubDao = clubDao;
	}

	@Override
	public List<Club> searchClubList() {

		return null;
	}

	@Override
	public Club searchClubByName(String clubName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Club> searchClubListByName(String clubName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addClub(Club club) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClub(String userId, String clubId) {
		// TODO Auto-generated method stub
		return false;
	}

}
