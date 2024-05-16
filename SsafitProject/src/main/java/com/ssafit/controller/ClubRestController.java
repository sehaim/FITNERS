package com.ssafit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Club;
import com.ssafit.model.service.ClubService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/club")
@Tag(name = "ClubRestController", description = "Club 관련 서비스/클럽 조회, 등록, 삭제 API")
@CrossOrigin
public class ClubRestController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";
	private static final String NONE = "NONE";

	private final ClubService clubService;

	public ClubRestController(ClubService clubService) {
		this.clubService = clubService;
	}

	// 전체 클럽 조회
	@GetMapping
	public ResponseEntity<?> getAllClub() {
		List<Club> list = clubService.searchClubList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 클럽 추가
	@PostMapping
	public ResponseEntity<?> addClub(@RequestBody Club club) {
		System.out.println(club.toString());

		System.out.println("controller : ");
		System.out.println(club.getClubId());
		System.out.println(club.getClubName());
		System.out.println(club.getClubDescription());
		System.out.println(club.getUserId());
		System.out.println();

		boolean result = clubService.addClub(club);
		if (!result) {
			return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.CREATED);
	}

//	@GetMapping("")
//	public ResponseEntity<?> addClub() {
//
//	}

}
