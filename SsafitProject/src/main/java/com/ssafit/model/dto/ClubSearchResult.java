package com.ssafit.model.dto;

public class ClubSearchResult {
	private int clubId;
	private String clubName;
	private String userId;
	private String clubDescription;
	private String userName;

	public ClubSearchResult() {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClubDescription() {
		return clubDescription;
	}

	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "ClubSearchResult [clubId=" + clubId + ", clubName=" + clubName + ", userId=" + userId
				+ ", clubDescription=" + clubDescription + ", userName=" + userName + "]";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
