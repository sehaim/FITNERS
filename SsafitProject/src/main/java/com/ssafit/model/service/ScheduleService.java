package com.ssafit.model.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ssafit.model.dto.ClubSchedule;
import com.ssafit.model.dto.UserSchedule;
import com.ssafit.model.dto.UserScheduleSearchResult;

public interface ScheduleService {
	// 전체 클럽 일정 조회
	public List<ClubSchedule> searchAllClubSchedule();

	// 전체 유저 일정 조회
	public List<UserSchedule> searchAllUserSchedule();

	// 클럽별 일정 조회
	public List<ClubSchedule> searchClubScheduleList(int clubId);

	// 유저별 일정 조회
	public List<UserScheduleSearchResult> searchUserScheduleList(String userId);

	// 클럽 일정 단일 조회 - clubId / schedule로 조회
	public ClubSchedule searchClubSchedule(int clubId, String schedule);

	// 유저 일정 단일 조회 - userId / schedule로 조회
	public UserSchedule searchUserSchedule(String userId, String schedule);

	// 클럽 일정 추가
	public boolean insertClubSchedule(int clubId, String schedule);

	// 유저 일정 추가
	public boolean insertUserSchedule(String userId, String schedule, int clubId);

	// 클럽 일정 삭제
	public boolean deleteClubSchedule(int scheduleId);

	// 유저 일정 삭제
	public boolean deleteUserSchedule(int scheduleId);
}
