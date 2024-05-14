package com.ssafit.model.dto;

public class Club {
	private int clubId;
	private String clubName;
	private String managerId;
	private String clubDesciption;

	public Club() {
		super();
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getClubDesciption() {
		return clubDesciption;
	}

	public void setClubDesciption(String clubDesciption) {
		this.clubDesciption = clubDesciption;
	}

	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName + ", managerId=" + managerId + ", clubDesciption="
				+ clubDesciption + "]";
	}

}
