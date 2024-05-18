package com.ssafit.model.dto;

public class Schedule {
	private int scheduleId;
	private String schedule;

	public Schedule() {
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", schedule=" + schedule + "]";
	}

}
