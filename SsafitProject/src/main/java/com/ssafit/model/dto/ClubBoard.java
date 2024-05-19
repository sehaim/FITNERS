package com.ssafit.model.dto;

public class ClubBoard {

	private int boardId;
	private String title;
	private String content;
	private int clubId;
	private String userId;
	private int viewCnt;
	private String createdAt;

	public ClubBoard() {
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ClubBoard [boardId=" + boardId + ", title=" + title + ", content=" + content + ", clubId=" + clubId
				+ ", userId=" + userId + ", viewCnt=" + viewCnt + ", createdAt=" + createdAt + "]";
	}

}
