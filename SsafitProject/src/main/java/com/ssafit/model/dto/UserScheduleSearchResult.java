package com.ssafit.model.dto;

public class UserScheduleSearchResult extends Schedule {
	private String userId;
	private String clubName;

	public UserScheduleSearchResult() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClubId() {
		return clubName;
	}

	public void setClubId(String clubId) {
		this.clubName = clubName;
	}

	@Override
	public String toString() {
		return "UserScheduleSearchResult [userId=" + userId + ", clubName=" + clubName + "]";
	}

}
