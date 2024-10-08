package com.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafit.model.dto.ClubSchedule;
import com.ssafit.model.dto.UserSchedule;
import com.ssafit.model.dto.UserScheduleSearchResult;

public interface ScheduleDao {

	// 전체 클럽 일정 조회
	public List<ClubSchedule> getAllClubSchedule();

	// 전체 유저 일정 조회
	public List<UserSchedule> getAllUserSchedule();

	// 클럽별 일정 조회
	public List<ClubSchedule> getClubSchedule(int clubId);

	// 유저별 일정 조회
	public List<UserScheduleSearchResult> getUserSchedule(String userId);

	// 클럽 일정 단일 조회 - clubId, schedule로 조회
	public ClubSchedule selectClubSchedule(Map<String, Object> map);

	// 유저 일정 단일 조회 - userId, schedule로 조회
	public UserSchedule selectUserSchedule(Map<String, Object> map);

	// 클럽 일정 단일 조회 - scheduleId로 조회
	public ClubSchedule selectClubScheduleById(int scheduleId);
	
	// 유저 일정 단일 조회 - scheduleId로 조회
	public UserSchedule selectUserScheduleById(int scheduleId);

	// 클럽 일정 추가
	public int insertClubSchedule(Map<String, Object> map);

	// 유저 일정 추가
	public int insertUserSchedule(Map<String, Object> map);

	// 클럽 일정 삭제
	public int deleteClubSchedule(int scheduleId);

	// 유저 일정 삭제
	public int deleteUserSchedule(int scheduleId);
	
	// 클럽 일정 자동 삭제
	public int deleteAutoClubSchedule();

	// 유저 일정 자동 삭제
	public int deleteAutoUserSchedule();

}
