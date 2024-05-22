package com.ssafit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Club;
import com.ssafit.model.dto.MemberRegist;
import com.ssafit.model.dto.UserScheduleSearchResult;
import com.ssafit.model.service.ClubService;
import com.ssafit.model.service.MemberService;
import com.ssafit.model.service.ScheduleService;
import com.ssafit.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/mypage")
@Tag(name = "Controller - MyPage", description = "마이 페이지 기능")
@CrossOrigin
public class MyPageRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	private final UserService userService;
	private final ClubService clubService;
	private final MemberService memberService;
	private final ScheduleService scheduleService;

	public MyPageRestController(UserService userService, ClubService clubService, MemberService memberService,
			ScheduleService scheduleService) {
		this.userService = userService;
		this.clubService = clubService;
		this.memberService = memberService;
		this.scheduleService = scheduleService;
	}

	@Operation(summary = "유저 아이디로 클럽 목록 조회", description = "매니저인 경우 해당 유저가 관리하는 클럽 목록 조회/일반 사용자인 경우 해당 유저가 속해있는 클럽 목록 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	@GetMapping("/{userId}/club")
	public ResponseEntity<?> getManagerClubList(@PathVariable("userId") String userId) {
		Map<String, Object> map = new HashMap<>();

		if (userService.search(userId) == null) {
			map.put("result", FAIL);
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}

		if (!userService.checkUserType(userId)) {
			List<Club> list = clubService.searchClubListByUserId(userId);

			map.put("result", SUCCESS);
			map.put("clubList", list);
		} else {
			List<Club> list = clubService.searchClubListByManager(userId);

			map.put("result", SUCCESS);
			map.put("clubList", list);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 유저 아이디로 개인 일정 조회
	@Operation(summary = "개인 일정 조회", description = "아이디에 해당하는 유저의 개인 일정 목록 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	@GetMapping("/user/{userId}/schedule")
	public ResponseEntity<?> addClub(@PathVariable("userId") String userId) {
		Map<String, Object> map = new HashMap<>();
		if (userService.search(userId) == null || userService.checkUserType(userId)) {
			map.put("result", FAIL);
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}

		List<UserScheduleSearchResult> list = scheduleService.searchUserScheduleList(userId);

		map.put("result", SUCCESS);
		map.put("scheduleList", list);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Operation(summary = "개인 일정 삭제")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	@DeleteMapping("/user/{userId}/schedule/{scheduleId}")
	public ResponseEntity<String> deleteUserSchedule(@PathVariable("userId") String userId,
			@PathVariable("scheduleId") int scheduleId) {
		if (!scheduleService.deleteUserSchedule(scheduleId)) {
			return new ResponseEntity<>(FAIL, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@Operation(summary = "클럽 가입 요청 조회", description = "아이디에 해당하는 유저가 관리하는 클럽의 가입 요청 목록 조회")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	@GetMapping("/manager/{userId}/registList")
	public ResponseEntity<?> getClubRegistList(@PathVariable("userId") String userId) {
		Map<String, Object> map = new HashMap<>();
		if (userService.search(userId) == null || !userService.checkUserType(userId)) {
			map.put("result", FAIL);
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}

		List<MemberRegist> list = memberService.getClubRegistList(userId);

		map.put("result", SUCCESS);
		map.put("clubRegistList", list);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@Operation(summary = "신규 클럽 개설")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "CREATED"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PostMapping("/club")
	public ResponseEntity<?> addClub(@RequestBody Club club) {
		boolean result = clubService.addClub(club);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}

		Club tmp = clubService.searchClubByName(club.getClubName());

		int clubId = tmp.getClubId();
		String userId = tmp.getUserId();

		memberService.applyMember(clubId, userId);
		memberService.approveMember(clubId, userId);

		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

	@Operation(summary = "가입 요청 승인", description = "클럽 가입 요청 승인 후 신규 멤버 추가")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "CREATED"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PostMapping("/manager/member/accepted")
	public ResponseEntity<?> approveRegist(@RequestBody Map<String, Object> map) {
		int clubId = (int) map.get("clubId");
		String userId = (String) map.get("userId");
		System.out.println(clubId);
		boolean result = memberService.approveMember(clubId, userId);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

	@Operation(summary = "가입 요청 거절", description = "클럽 가입 요청 거절 후 가입 요청 목록에서 제거")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST") })
	@PostMapping("/manager/member/denied")
	public ResponseEntity<?> declineRegist(@RequestBody Map<String, Object> map) {
		int clubId = (int) map.get("clubId");
		String userId = (String) map.get("userId");
		boolean result = memberService.declineMember(clubId, userId);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

}
