package com.groupc.flippedclass.services;

import java.util.List;

import com.groupc.flippedclass.dto.TopicDto;
import com.groupc.flippedclass.entity.Topic;

public interface TopicService {
	public List<Topic> allTopics();
	public boolean addTopic(Topic topic);
	public boolean deleteTopic(Topic topic);
}
