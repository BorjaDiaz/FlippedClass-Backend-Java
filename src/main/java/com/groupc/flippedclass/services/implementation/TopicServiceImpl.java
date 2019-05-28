package com.groupc.flippedclass.services.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.entity.Topic;
import com.groupc.flippedclass.repository.TopicRepository;
import com.groupc.flippedclass.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService{

	
	static Logger log = Logger.getLogger(TopicServiceImpl.class.getName());
	
	
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
			log.error(e.getMessage(),e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteTopic(Topic topic) {
		try {
			Topic topicToDelete = topicRepository.getOne(topic.getId());
			topicRepository.delete(topicToDelete);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean updateTopic(Topic topic) {
		try {
			Topic topicToUpdate = topicRepository.getOne(topic.getId());
			topicToUpdate.setTopic(topic.getTopic());
			topicRepository.save(topicToUpdate);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			return false;
		}
		
	}

}
