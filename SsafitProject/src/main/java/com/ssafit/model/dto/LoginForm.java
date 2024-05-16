package com.ssafit.model.dto;

public class LoginForm {
	private String userId;
	private String userPassword;

	public String getUserId() {
		return userId;
	}

	public LoginForm() {
		super();
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "LoginForm [userId=" + userId + ", userPassword=" + userPassword + "]";
	}
}
