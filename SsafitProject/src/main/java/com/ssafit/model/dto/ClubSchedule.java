package com.ssafit.model.dto;

public class ClubSchedule extends Schedule {
	private int clubId;

	public ClubSchedule() {
		super();
	}

	public int getClubId() {
		return clubId;
	}

	public void setUserId(int clubId) {
		this.clubId = clubId;
	}

	@Override
	public String toString() {
		return "ClubSchedule [clubId=" + clubId + "]";
	}

}
