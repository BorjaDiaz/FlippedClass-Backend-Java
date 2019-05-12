package com.groupc.flippedclass.controller;

import java.util.List;

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
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/api/topic/table")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Topic> topicTable() {
		return topicService.allTopics();
	}
	
	@PostMapping("/api/topic/newTopic")
	@PreAuthorize("hasRole('ADMIN')")
    public void addTopic(@RequestBody TopicDto topicDto) {
		topicService.addTopic(TopicConverter.topicDtoToEntity(topicDto));
    }
	
	@PostMapping("/api/topic/deleteTopic")
	@PreAuthorize("hasRole('ADMIN')")
    public void deleteTopic(@RequestBody TopicDto topicDto) {
		topicService.deleteTopic(TopicConverter.topicDtoToEntity(topicDto));
    }
}
