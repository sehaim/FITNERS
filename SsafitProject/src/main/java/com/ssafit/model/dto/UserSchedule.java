package com.ssafit.model.dto;

public class UserSchedule extends Schedule {
	private String userId;

	public UserSchedule() {
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
