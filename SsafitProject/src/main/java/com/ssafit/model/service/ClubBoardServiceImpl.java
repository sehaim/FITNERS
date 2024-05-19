package com.ssafit.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.model.dao.ClubBoardDao;
import com.ssafit.model.dto.ClubBoard;
import com.ssafit.model.dto.ClubBoardSearchResult;

@Service
public class ClubBoardServiceImpl implements ClubBoardService {

	private final ClubBoardDao clubBoardDao;

	public ClubBoardServiceImpl(ClubBoardDao clubBoardDao) {
		this.clubBoardDao = clubBoardDao;
	}

	@Transactional
	@Override
	public ClubBoard getClubBoard(int clubId) {
		return clubBoardDao.selectClubBoard(clubId);
	}

	@Transactional
	@Override
	public ClubBoardSearchResult getClubBoardDetail(int clubId) {
		return clubBoardDao.selectClubBoardDetail(clubId);
	}

	@Transactional
	@Override
	public boolean writeClubBoard(ClubBoard clubBoard) {
		int clubId = clubBoard.getClubId();

		if (clubBoardDao.selectClubBoard(clubId) != null) {
			return false;
		}

		clubBoardDao.insertClubBoard(clubBoard);
		return true;
	}

	@Transactional
	@Override
	public boolean modifyClubBoard(ClubBoard clubBoard) {
		int clubId = clubBoard.getClubId();

		if (clubBoardDao.selectClubBoard(clubId) == null) {
			return false;
		}

		clubBoardDao.updateClubBoard(clubBoard);
		return true;
	}

	@Transactional
	@Override
	public boolean removeClubBoard(int clubId) {
		if (clubBoardDao.selectClubBoard(clubId) != null) {
			return false;
		}

		clubBoardDao.deleteClubBoard(clubId);
		return true;
	}

}
