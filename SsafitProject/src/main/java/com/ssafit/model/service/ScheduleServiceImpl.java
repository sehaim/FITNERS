package com.ssafit.model.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafit.model.dao.ClubDao;
import com.ssafit.model.dao.ScheduleDao;
import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.ClubSchedule;
import com.ssafit.model.dto.UserSchedule;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	private final ScheduleDao scheduleDao;
	private final ClubDao clubDao;
	private final UserDao userDao;

	public ScheduleServiceImpl(ScheduleDao scheduleDao, ClubDao clubDao, UserDao userDao) {
		this.scheduleDao = scheduleDao;
		this.clubDao = clubDao;
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public List<ClubSchedule> searchAllClubSchedule() {
		return scheduleDao.getAllClubSchedule();
	}

	@Transactional
	@Override
	public List<UserSchedule> searchAllUserSchedule() {
		return scheduleDao.getAllUserSchedule();
	}

	@Transactional
	@Override
	public List<ClubSchedule> searchClubScheduleList(int clubId) {
		return scheduleDao.getClubSchedule(clubId);
	}

	@Transactional
	@Override
	public List<UserSchedule> searchUserScheduleList(String userId) {
		return scheduleDao.getUserSchedule(userId);
	}

	@Transactional
	@Override
	public ClubSchedule searchClubSchedule(int clubId, String schedule) {
		Map<String, Object> map = new HashMap<>();

		map.put("clubId", clubId);
		map.put("schedule", schedule);

		return scheduleDao.selectClubSchedule(map);
	}

	@Transactional
	@Override
	public UserSchedule searchUserSchedule(String userId, String schedule) {
		Map<String, Object> map = new HashMap<>();

		map.put("userId", userId);
		map.put("schedule", schedule);

		return scheduleDao.selectUserSchedule(map);
	}

	@Transactional
	@Override
	public boolean insertClubSchedule(int clubId, String schedule) {
		Map<String, Object> map = new HashMap<>();

		map.put("clubId", clubId);
		map.put("schedule", schedule);

		if (scheduleDao.selectClubSchedule(map) != null || clubDao.select(clubId) == null) {
			return false;
		}

		scheduleDao.insertClubSchedule(map);
		return true;
	}

	@Transactional
	@Override
	public boolean insertUserSchedule(String userId, String schedule) {
		Map<String, Object> map = new HashMap<>();

		map.put("userId", userId);
		map.put("schedule", schedule);

		if (scheduleDao.selectUserSchedule(map) != null || userDao.select(userId) == null) {
			return false;
		}

		scheduleDao.insertUserSchedule(map);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteClubSchedule(int clubId, String schedule) {
		Map<String, Object> selectMap = new HashMap<>();

		selectMap.put("clubId", clubId);
		selectMap.put("schedule", schedule);

		ClubSchedule clubSchedule = scheduleDao.selectClubSchedule(selectMap);
		int scheduleId = clubSchedule.getScheduleId();

		scheduleDao.deleteClubSchedule(scheduleId);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteUserSchedule(String userId, String schedule) {
		Map<String, Object> selectMap = new HashMap<>();

		selectMap.put("userId", userId);
		selectMap.put("schedule", schedule);

		UserSchedule userSchedule = scheduleDao.selectUserSchedule(selectMap);
		int scheduleId = userSchedule.getScheduleId();

		scheduleDao.deleteUserSchedule(scheduleId);
		return true;
	}

}
