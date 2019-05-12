package com.groupc.flippedclass.converter;

import org.springframework.beans.BeanUtils;

import com.groupc.flippedclass.dto.TopicDto;
import com.groupc.flippedclass.entity.Topic;

public class TopicConverter {

	public static Topic topicDtoToEntity(TopicDto topicDto) {
		Topic topic = new Topic();
		BeanUtils.copyProperties(topicDto, topic);
		return topic;
	}
}
