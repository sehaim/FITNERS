package com.ssafit.model.dto;

public class Member {
	private String userId;
	private int clubId;
	private boolean access;

	public Member() {
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

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", clubId=" + clubId + ", access=" + access + "]";
	}

}
