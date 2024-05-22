package com.ssafit.controller;

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

import com.ssafit.model.dto.ClubBoard;
import com.ssafit.model.dto.ClubBoardSearchResult;
import com.ssafit.model.service.ClubBoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/club")
@Tag(name = "Controller - ClubBoard", description = "클럽 공지사항 관리 기능")
@CrossOrigin
public class ClubBoardRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private final ClubBoardService clubBoardService;

	public ClubBoardRestController(ClubBoardService clubBoardService) {
		this.clubBoardService = clubBoardService;
	}

	@Operation(summary = "클럽 공지사항 상세 조회", description = "클럽 공지사항 ID에 해당하는 공지사항 상세 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK") })
	@GetMapping("/board/{clubId}")
	public ResponseEntity<?> searchClubBoard(@PathVariable("clubId") int clubId) {
		ClubBoardSearchResult clubBoardSearchResult = clubBoardService.getClubBoardDetail(clubId);

		if (clubBoardSearchResult == null) {
			ClubBoard clubBoard = new ClubBoard();
			clubBoard.setClubId(clubId);
			clubBoard.setTitle("");
			clubBoard.setContent("아직 공지사항이 없습니다.");
			clubBoardService.writeClubBoard(clubBoard);
			clubBoardSearchResult = clubBoardService.getClubBoardDetail(clubId);
		}

		return new ResponseEntity<>(clubBoardSearchResult, HttpStatus.OK);
	}

	@Operation(summary = "클럽 공지사항 등록", description = "클럽 공지사항 신규 등록")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "CREATED"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PostMapping("/board/add")
	public ResponseEntity<?> writeClubBoard(@RequestBody ClubBoard clubBoard) {
		boolean result = clubBoardService.writeClubBoard(clubBoard);

		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

	@Operation(summary = "클럽 공지사항 수정", description = "클럽 공지사항 ID에 해당하는 클럽 공지사항 수정")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "CREATED"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PutMapping("/board/{clubId}")
	public ResponseEntity<?> updateClubBoard(@PathVariable("clubId") int clubId, @RequestBody ClubBoard clubBoard) {
		boolean result = clubBoardService.modifyClubBoard(clubId, clubBoard);

		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

}
