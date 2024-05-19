package com.ssafit.model.service;

import com.ssafit.model.dto.ClubBoard;
import com.ssafit.model.dto.ClubBoardSearchResult;

public interface ClubBoardService {

	// 클럽 게시글(공지사항) 조회
	public ClubBoard getClubBoard(int clubId);

	// 클럽 게시글(공지사항) 상세조회
	public ClubBoardSearchResult getClubBoardDetail(int clubId);

	// 클럽 게시글(공지사항) 등록
	public boolean writeClubBoard(ClubBoard clubBoard);

	// 클럽 게시글(공지사항) 수정
	public boolean modifyClubBoard(ClubBoard clubBoard);

	// 클럽 게시글(공지사항) 삭제
	public boolean removeClubBoard(int clubId);

}
