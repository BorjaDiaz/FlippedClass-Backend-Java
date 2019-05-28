package com.groupc.flippedclass.dto;

public class TopicDto {
	
	private Long id;
	private String topic;
	
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
	
	public String getAll() {
		return "Id: "+id+", topic:"+topic;
	}
	
}
