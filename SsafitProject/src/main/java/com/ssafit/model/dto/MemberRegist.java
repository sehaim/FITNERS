package com.ssafit.model.dto;

public class MemberRegist extends Member {
	private String userName;

	public MemberRegist() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MemberRegist [userName=" + userName + "]";
	}

}
