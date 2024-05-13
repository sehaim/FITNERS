package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Club;

public interface ClubDao {
	// 유저 이름 조회
	public List<Club> selectClubByName(String clubName);

	// 매니저 아이디로 클럽 조회
	public List<Club> selectClubByManager(String userId);

	// 클럽 조회
	public Club select(int clubId);

	// 클럽개설
	public int insertClub(Club club);

	// 클럽삭제 - 유저(매니저 아이디, 클럽명 필요)
	public int deleteClub(String userId, String clubName);
}
