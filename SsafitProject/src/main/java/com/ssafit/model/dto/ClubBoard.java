package com.ssafit.model.dto;

public class ClubBoard {

	private int clubId;
	private String title;
	private String content;
	private String createdAt;

	public ClubBoard() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ClubBoard [clubId=" + clubId + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
				+ "]";
	}

}
