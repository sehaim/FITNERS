package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Board;

public interface BoardService {
	// 게시글 전체 조회
	public List<Board> searchBoardList();

	// 게시글 상세 조회
	public Board searchBoardDetail(int BoardId);

	// 게시글 이름으로 조회
	public List<Board> searchBoardListByTitle(String title);

	// 인기 게시글 조회
	public List<Board> searchPopularBoard(String startDate);

	// 게시글 등록
	public boolean writeBoard(Board board);

	// 게시글 삭제
	public boolean removeBoard(int boardId);

	// 게시글 수정
	public boolean modifyBoard(Board board);
}
