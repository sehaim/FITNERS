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

	// 전체 클럽 목록 조회
	@Transactional
	@Override
	public List<ClubSearchResult> searchClubList() {
		return clubDao.selectAllClub();
	}

	// 클럽 이름으로 조회 - 검색어 포함 클럽 목록 
	@Transactional
	@Override
	public List<Club> searchClubListByName(String clubName) {
		return clubDao.selectClubListByName(clubName);
	}

	// 클럽 이름으로 조회 - 단일 클럽
	@Transactional
	@Override
	public Club searchClubByName(String clubName) {
		return clubDao.selectClubByName(clubName);
	}

	// 클럽 아이디로 조회 - 단일 클럽
	@Transactional
	@Override
	public Club searchClubById(int clubId) {
		return clubDao.select(clubId);
	}

	// 매니저 아이디로 조회 - 매니저가 담당하는 클럽 목록
	@Transactional
	@Override
	public List<Club> searchClubListByManager(String userId) {
		return clubDao.selectClubListByManager(userId);
	}

	// 유저 아이디로 조회 - 유저가 속한 클럽 목록
	@Transactional
	@Override
	public List<Club> searchClubListByUserId(String userId) {
		return clubDao.selectClubListByUserId(userId);
	}

	// 클럽 추가
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

	// 클럽 삭제
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
