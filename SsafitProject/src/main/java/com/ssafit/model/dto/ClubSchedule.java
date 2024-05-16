package com.ssafit.model.dto;

public class ClubSchedule extends Schedule {
	private String userId;

	public ClubSchedule() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserSchedule [userId=" + userId + "]";
	}

}
