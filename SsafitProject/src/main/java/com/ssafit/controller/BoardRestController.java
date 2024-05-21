package com.ssafit.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Board;
import com.ssafit.model.service.BoardService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/board")
@Tag(name = "Controller - Board", description = "게시판 관리 기능")
@CrossOrigin
public class BoardRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private final BoardService boardService;

	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	// 게시글 전체 조회
	@GetMapping
	public ResponseEntity<?> list() {
		List<Board> list = boardService.searchBoardList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 게시글 상세 보기
	@GetMapping("/{boardId}")
	public ResponseEntity<Board> detail(@PathVariable("boardId") int boardId) {
		Board board = boardService.searchBoardDetail(boardId);
		if (board != null)
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
	}

	// 게시글 제목으로 검색
	@GetMapping("/search/{title}")
	public ResponseEntity<?> detail(@PathVariable("title") String title) {
		List<Board> list = boardService.searchBoardListByTitle(title);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 인기 게시글 조회
	@GetMapping("/popular")
	public ResponseEntity<?> getPopularBoardList() {
		LocalDate today = LocalDate.now();
		String startDate = today.minusDays(7).toString() + " 00:00:00";

		List<Board> list = boardService.searchPopularBoard(startDate);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 게시글 등록
	@PostMapping
	public ResponseEntity<?> write(@RequestBody Board board) {
		boardService.writeBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	// 게시글 수정
	@PutMapping("/{boardId}")
	public ResponseEntity<String> update(@PathVariable("boardId") int boardId, @RequestBody Board board) {
		board.setBoardId(boardId);
		if (boardService.modifyBoard(board))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	// 게시글 삭제
	@DeleteMapping("/{boardId}")
	public ResponseEntity<String> delete(@PathVariable("boardId") int boardId) {
		if (boardService.removeBoard(boardId))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
