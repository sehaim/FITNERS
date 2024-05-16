package com.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.model.dao.ClubDao;
import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.Club;
import com.ssafit.model.dto.ClubSearchResult;

@Service
public class ClubServiceImpl implements ClubService {

	private final ClubDao clubDao;
	private final UserDao userDao;

	public ClubServiceImpl(ClubDao clubDao, UserDao userDao) {
		this.clubDao = clubDao;
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public List<ClubSearchResult> searchClubList() {
		return clubDao.selectAllClub();
	}

	@Transactional
	@Override
	public Club searchClubByName(String clubName) {
		return clubDao.selectClubByName(clubName);
	}

	@Transactional
	@Override
	public List<Club> searchClubListByName(String clubName) {
		return clubDao.selectClubListByName(clubName);
	}

	@Transactional
	@Override
	public Club searchClubById(int clubId) {
		return clubDao.select(clubId);
	}

	@Transactional
	@Override
	public List<Club> searchClubListByUserId(String userId) {
		return clubDao.selectClubListByUserId(userId);
	}

	@Transactional
	@Override
	public boolean addClub(Club club) {
		String clubName = club.getClubName();
		String userId = club.getUserId();

		if (clubDao.selectClubByName(clubName) != null || userDao.select(userId) == null) {
			return false;
		}

		clubDao.insertClub(club);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteClub(String userId, String clubName) {
		Club club = clubDao.selectClubByName(clubName);

		if (club == null) {
			return false;
		} else if (club.getUserId() != userId) {
			return false;
		}

		clubDao.deleteClub(userId, clubName);

		return true;
	}

}
