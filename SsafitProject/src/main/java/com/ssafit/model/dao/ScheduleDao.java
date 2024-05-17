package com.ssafit.model.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.ssafit.model.dto.ClubSchedule;
import com.ssafit.model.dto.UserSchedule;

public interface ScheduleDao {

	// 전체 클럽 일정 조회
	public List<ClubSchedule> getAllClubSchedule();

	// 전체 유저 일정 조회
	public List<UserSchedule> getAllUserSchedule();

	// 클럽별 일정 조회
	public List<ClubSchedule> getClubSchedule(int clubId);

	// 유저별 일정 조회
	public List<UserSchedule> getUserSchedule(String userId);

	// 클럽 일정 단일 조회
	public ClubSchedule selectClubSchedule(int clubId, LocalDateTime schedule);

	// 유저 일정 단일 조회
	public UserSchedule selectUserSchedule(String userId, LocalDateTime schedule);

	// 클럽 일정 추가
	public int insertClubSchedule(Map<String, Object> map);

	// 유저 일정 추가
	public int insertUserSchedule(Map<String, Object> map);

	// 클럽 일정 삭제
	public int deleteClubSchedule(int scheduleId);

	// 유저 일정 삭제
	public int deleteUserSchedule(int scheduleId);

}
