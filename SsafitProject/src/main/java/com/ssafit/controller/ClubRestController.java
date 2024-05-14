package com.ssafit.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/club")
@Tag(name = "ClubRestController", description = "User 관련 서비스/로그인, 로그아웃, 회원가입 API")
@CrossOrigin
public class ClubRestController {

	
	
}
