package com.ssafit.model.dto;

public class ClubBoardSearchResult extends ClubBoard {

	private String userName;

	public ClubBoardSearchResult() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "ClubBoardSearchResult [userName=" + userName + "]";
	}

}
