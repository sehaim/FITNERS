package com.ssafit.model.dto;

public class UserSchedule extends Schedule {
	private String userId;
	private int clubId;

	public UserSchedule() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	@Override
	public String toString() {
		return "UserSchedule [userId=" + userId + ", clubId=" + clubId + "]";
	}

}
