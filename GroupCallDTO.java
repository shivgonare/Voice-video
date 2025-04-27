package com.example.demo.dto;

import java.util.List;

public class GroupCallDTO {
    public Long id;
    public String topic;
    public String startTime;
    public String endTime;
    public List<Long> participantIds;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<Long> getParticipantIds() {
		return participantIds;
	}
	public void setParticipantIds(List<Long> participantIds) {
		this.participantIds = participantIds;
	}
    
    
    
}
