package com.ssafit.model.dao;

import java.util.List;

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

	// 클럽 일정 추가
	public int insertClubSchedule(int clubId);

	// 유저 일정 추가
	public int insertUserSchedule(String userId);

	// 클럽 일정 삭제
	public int deleteClubSchedule(int clubId);

	// 유저 일정 삭제
	public int deleteUserSchedule(String userId);

}
