package com.ssafit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Club;
import com.ssafit.model.dto.ClubSearchResult;
import com.ssafit.model.service.ClubService;
import com.ssafit.model.service.MemberService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/club")
@Tag(name = "ClubRestController", description = "Club 관련 서비스/클럽 조회, 등록, 삭제 API")
@CrossOrigin
public class ClubRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private final ClubService clubService;
	private final MemberService memberService;

	public ClubRestController(ClubService clubService, MemberService memberService) {
		this.clubService = clubService;
		this.memberService = memberService;
	}

	// 전체 클럽 조회
	@GetMapping
	public ResponseEntity<?> getAllClub() {
		List<ClubSearchResult> list = clubService.searchClubList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 클럽 추가
	@PostMapping
	public ResponseEntity<?> addClub(@RequestBody Club club) {
		boolean result = clubService.addClub(club);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

	// 클럽 아이디, 유저 아이디로 해당 유저가 클럽에 가입중인지 조회
	@GetMapping("/{clubId}&{userId}")
	public ResponseEntity<Map<String, Object>> getStatus(@PathVariable("clubId") int clubId,
			@PathVariable("userId") String userId) {
		Map<String, Object> map = new HashMap<>();

		String searchResult = memberService.getMember(clubId, userId);
		map.put("status", searchResult);

		Club club = clubService.searchClubById(clubId);
		map.put("club", club);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
