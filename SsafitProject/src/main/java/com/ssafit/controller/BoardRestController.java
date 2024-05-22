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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

	@Operation(summary = "게시글 전체 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO_CONTENT") })
	@GetMapping
	public ResponseEntity<?> list() {
		List<Board> list = boardService.searchBoardList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	@Operation(summary = "게시글 상세 조회", description = "게시글 ID에 해당하는 게시글 상세 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	@GetMapping("/{boardId}")
	public ResponseEntity<Board> detail(@PathVariable("boardId") int boardId) {
		Board board = boardService.searchBoardDetail(boardId);
		if (board != null)
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "게시글 검색", description = "검색어를 제목에 포함하고 있는 게시글 목록 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO_CONTENT") })
	@GetMapping("/search/{title}")
	public ResponseEntity<?> detail(@PathVariable("title") String title) {
		List<Board> list = boardService.searchBoardListByTitle(title);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	@Operation(summary = "인기 게시글 조회", description = "최근 일주일(7일)이내에 작성된 게시글 중 조회수 상위 3건 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO_CONTENT") })
	@GetMapping("/popular")
	public ResponseEntity<?> getPopularBoardList() {
		LocalDate today = LocalDate.now();
		String startDate = today.minusDays(7).toString() + " 00:00:00";

		List<Board> list = boardService.searchPopularBoard(startDate);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	@Operation(summary = "게시글 등록", description = "신규 게시글 등록")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "CREATED"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PostMapping
	public ResponseEntity<?> write(@RequestBody Board board) {
		if (boardService.writeBoard(board)) {
			return new ResponseEntity<Board>(board, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "게시글 수정", description = "게시글 ID에 해당하는 게시글 수정/본인 작성 게시글에 한함")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "CREATED"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PutMapping("/{boardId}")
	public ResponseEntity<String> update(@PathVariable("boardId") int boardId, @RequestBody Board board) {
		board.setBoardId(boardId);
		if (boardService.modifyBoard(board))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "게시글 삭제", description = "게시글 ID에 해당하는 게시글 삭제/본인 작성 게시글에 한함")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	@DeleteMapping("/{boardId}")
	public ResponseEntity<String> delete(@PathVariable("boardId") int boardId) {
		if (boardService.removeBoard(boardId))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
}
