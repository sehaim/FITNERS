package com.ssafit.controller;

import java.time.LocalDateTime;
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
import com.ssafit.model.dto.ClubSchedule;
import com.ssafit.model.dto.ClubSearchResult;
import com.ssafit.model.service.ClubService;
import com.ssafit.model.service.MemberService;
import com.ssafit.model.service.ScheduleService;

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
	private final ScheduleService scheduleService;

	public ClubRestController(ClubService clubService, MemberService memberService, ScheduleService scheduleService) {
		this.clubService = clubService;
		this.memberService = memberService;
		this.scheduleService = scheduleService;
	}

	// 전체 클럽 조회
	@GetMapping
	public ResponseEntity<?> getAllClub() {
		List<ClubSearchResult> list = clubService.searchClubList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 클럽 추가
	// 마이페이지 컨트롤러로 이동 예정
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

	// 클럽 일정 조회
	@PostMapping("/{clubId}/schedule")
	public ResponseEntity<List> getClubSchedule(@PathVariable("clubId") int clubId) {
		List<ClubSchedule> clubScheduleList = scheduleService.searchClubScheduleList(clubId);

		return new ResponseEntity<>(clubScheduleList, HttpStatus.OK);
	}

	// 클럽 가입 요청
	@PostMapping("/{clubId}&{userId}/regist")
	public ResponseEntity<?> registClub(@PathVariable("clubId") int clubId, @PathVariable("userId") String userId) {
		boolean result = memberService.applyMember(clubId, userId);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 개인 일정 추가
	@PostMapping("/{clubId}&{userId}/schedule/add")
	public ResponseEntity<?> addUserSchedule(@PathVariable("clubId") int clubId, @PathVariable("userId") String userId,
			@RequestBody LocalDateTime schedule) {
		if (scheduleService.searchClubSchedule(clubId, schedule) == null) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		boolean result = scheduleService.insertUserSchedule(userId, schedule);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 클럽 일정 추가
	@PostMapping("/{clubId}/schedule/add")
	public ResponseEntity<?> addClubSchedule(@PathVariable("clubId") int clubId, @RequestBody LocalDateTime schedule) {

		if (scheduleService.searchClubSchedule(clubId, schedule) != null) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		boolean result = scheduleService.insertClubSchedule(clubId, schedule);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

}
