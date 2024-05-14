package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Club;

public interface ClubService {
	// 전체 클럽 조회
	public List<Club> searchClubList();

	// 클럽 이름으로 조회 (1개의 클럽)
	public Club searchClubByName(String clubName);

	// 클럽 이름으로 조회 (목록)
	public List<Club> searchClubListByName(String clubName);

	// 클럽 등록
	public boolean addClub(Club club);

	// 클럽 삭제
	public boolean deleteClub(String userId, String clubId);

}
