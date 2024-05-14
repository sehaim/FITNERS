package com.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.model.dao.ClubDao;
import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.Club;

@Service
public class ClubServiceImpl implements ClubService {

	private final ClubDao clubDao;

	public ClubServiceImpl(ClubDao clubDao) {
		this.clubDao = clubDao;
	}

	@Transactional
	@Override
	public List<Club> searchClubList() {
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
	public boolean addClub(Club club) {
		int clubId = club.getClubId();
		String clubName = club.getClubName();

		if (clubDao.select(clubId) != null) {
			return false;
		} else if (clubDao.select(clubId).getClubName() == clubName) {
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
		} else if (club.getManagerId() != userId) {
			return false;
		}

		clubDao.deleteClub(userId, clubName);

		return true;
	}

}
