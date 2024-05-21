package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Board;

public interface BoardDao {
	// 게시글 전체 조회
	public List<Board> selectBoardList();

	// 게시글 상세 조회
	public Board selectOne(int BoardId);
	
	// 게시글 이름으로 조회
	public List<Board> selectBoardListByTitle(String title);

	// 인기 게시글 조회
	public List<Board> selectPopularBoard(String startDate);

	// 게시글 등록
	public int insertBoard(Board board);

	// 게시글 삭제
	public int deleteBoard(int boardId);

	// 게시글 수정
	public int updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int boardId);
}
