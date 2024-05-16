package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Club;
import com.ssafit.model.dto.ClubSearchResult;

public interface ClubDao {
	// 전체 클럽 조회
	public List<ClubSearchResult> selectAllClub();

	// 클럽 이름으로 클럽 목록 조회
	public List<Club> selectClubListByName(String clubName);

	// 매니저 아이디로 클럽 목록 조회
	public List<Club> selectClubListByManager(String userId);

	// 클럽아이디로 조회
	public Club select(int clubId);

	// 클럽이름으로 조회
	public Club selectClubByName(String clubName);

	// 유저아이디로 조회
	public List<Club> selectClubListByUserId(String userId);

	// 클럽개설
	public int insertClub(Club club);

	// 클럽삭제 - 유저(매니저 아이디, 클럽명 필요)
	public int deleteClub(String userId, String clubName);
}
