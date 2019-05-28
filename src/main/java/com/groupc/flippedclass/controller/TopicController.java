package com.groupc.flippedclass.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.flippedclass.converter.TopicConverter;
import com.groupc.flippedclass.dto.TopicDto;
import com.groupc.flippedclass.entity.Topic;
import com.groupc.flippedclass.services.TopicService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TopicController {
	
	 static Logger log = Logger.getLogger(TopicController.class.getName());
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/api/topic/table")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Topic> topicTable() {
		log.info("En topicTable");
		return topicService.allTopics();
	}
	
	@PostMapping("/api/topic/newTopic")
	@PreAuthorize("hasRole('ADMIN')")
    public void addTopic(@RequestBody TopicDto topicDto) {
		log.info("En addTopic");
		log.debug(topicDto.getAll());
		topicService.addTopic(TopicConverter.topicDtoToEntity(topicDto));
    }
	
	@PostMapping("/api/topic/deleteTopic")
	@PreAuthorize("hasRole('ADMIN')")
    public void deleteTopic(@RequestBody TopicDto topicDto) {
		log.info("En deleteTopic");
		log.debug(topicDto.getAll());
		topicService.deleteTopic(TopicConverter.topicDtoToEntity(topicDto));
    }
	
	@PostMapping("/api/topic/updateTopic")
	@PreAuthorize("hasRole('ADMIN')")
    public void updateTopic(@RequestBody TopicDto topicDto) {
		log.info("En updateTopic");
		log.debug(topicDto.getAll());
		topicService.updateTopic(TopicConverter.topicDtoToEntity(topicDto));
    }
}
