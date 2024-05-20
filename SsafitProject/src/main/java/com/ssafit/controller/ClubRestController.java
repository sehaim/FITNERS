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

import com.ssafit.model.dto.ClubSchedule;
import com.ssafit.model.dto.ClubSearchResult;
import com.ssafit.model.service.ClubService;
import com.ssafit.model.service.MemberService;
import com.ssafit.model.service.ScheduleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/club")
@Tag(name = "Controller - Club", description = "클럽 페이지 기능")
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

	// 클럽 아이디, 유저 아이디로 해당 유저가 클럽에 가입중인지 조회
	@GetMapping("/{clubId}/{userId}")
	public ResponseEntity<String> getStatus(@PathVariable("clubId") int clubId, @PathVariable("userId") String userId) {
		Map<String, Object> map = new HashMap<>();

		String searchResult = memberService.getMember(clubId, userId);

		return new ResponseEntity<>(searchResult, HttpStatus.OK);
	}

	// 클럽 일정 조회
	@PostMapping("/schedule")
	public ResponseEntity<List> getClubSchedule(@RequestBody Map<String, Integer> clubIdMap) {
		List<ClubSchedule> clubScheduleList = scheduleService.searchClubScheduleList(clubIdMap.get("clubId"));

		return new ResponseEntity<>(clubScheduleList, HttpStatus.OK);
	}

	// 클럽 가입 요청
	@PostMapping("/regist")
	public ResponseEntity<?> registClub(@RequestBody Map<String, Object> map) {
		int clubId = Integer.valueOf(map.get("clubId").toString());
		String userId = (String) map.get("userId");
		boolean result = memberService.applyMember(clubId, userId);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 클럽 일정 추가
	@PostMapping("/schedule/add")
	public ResponseEntity<?> addClubSchedule(@RequestBody Map<String, Object> map) {
		int clubId = Integer.valueOf(map.get("clubId").toString());
		String schedule = (String) map.get("schedule");

		if (scheduleService.searchClubSchedule(clubId, schedule) != null) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		boolean result = scheduleService.insertClubSchedule(clubId, schedule);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 개인 일정 추가
	@PostMapping("/user/schedule/add")
	public ResponseEntity<?> addUserSchedule(@RequestBody Map<String, Object> map) {
		int clubId = Integer.valueOf(map.get("clubId").toString());
		String userId = (String) map.get("userId");
		String schedule = (String) map.get("schedule");

		if (scheduleService.searchClubSchedule(clubId, schedule) == null) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		boolean result = scheduleService.insertUserSchedule(userId, schedule, clubId);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

}
