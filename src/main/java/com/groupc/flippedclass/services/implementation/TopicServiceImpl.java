package com.groupc.flippedclass.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.entity.Topic;
import com.groupc.flippedclass.repository.TopicRepository;
import com.groupc.flippedclass.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	TopicRepository topicRepository;
	
	
	@Override
	public List<Topic> allTopics() {
		return topicRepository.findAll();
	}


	@Override
	public boolean addTopic(Topic topic) {
		try {
			topicRepository.save(topic);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteTopic(Topic topic) {
		try {
			Topic topicToDelete = topicRepository.findById(topic.getId()).get();
			topicRepository.delete(topicToDelete);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
