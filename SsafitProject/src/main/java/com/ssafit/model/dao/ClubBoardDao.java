package com.ssafit.model.dao;

import com.ssafit.model.dto.ClubBoard;
import com.ssafit.model.dto.ClubBoardSearchResult;

public interface ClubBoardDao {

	// 클럽 게시글(공지사항) 조회
	public ClubBoard selectClubBoard(int clubId);

	// 클럽 게시글(공지사항) 상세조회
	public ClubBoardSearchResult selectClubBoardDetail(int clubId);

	// 클럽 게시글(공지사항) 등록
	public int insertClubBoard(ClubBoard clubBoard);

	// 클럽 게시글(공지사항) 수정
	public int updateClubBoard(ClubBoard clubBoard);

	// 클럽 게시글(공지사항) 삭제
	public int deleteClubBoard(int clubId);

}
