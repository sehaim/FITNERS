package com.ssafit.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.model.dao.BoardDao;
import com.ssafit.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Transactional
	@Override
	public List<Board> searchBoardList() {
		return boardDao.selectBoardList();
	}

	@Transactional
	@Override
	public Board searchBoardDetail(int BoardId) {
		boardDao.updateViewCnt(BoardId);
		return boardDao.selectOne(BoardId);
	}

	@Transactional
	@Override
	public List<Board> searchPopularBoard(String startDate) {
		return boardDao.selectPopularBoard(startDate);
	}

	@Transactional
	@Override
	public boolean writeBoard(Board board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Transactional
	@Override
	public boolean removeBoard(int boardId) {
		return boardDao.deleteBoard(boardId) == 1;
	}

	@Transactional
	@Override
	public boolean modifyBoard(Board board) {
		return boardDao.updateBoard(board) == 1;
	}

}
