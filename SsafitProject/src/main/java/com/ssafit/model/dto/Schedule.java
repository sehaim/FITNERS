package com.ssafit.model.dto;

import java.time.LocalDateTime;

public class Schedule {
	private int scheduleId;
	private LocalDateTime schedule;

	public Schedule() {
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDateTime getSchedule() {
		return schedule;
	}

	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", schedule=" + schedule + "]";
	}

}
