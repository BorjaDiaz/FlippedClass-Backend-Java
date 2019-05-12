package com.groupc.flippedclass.converter;

import org.springframework.beans.BeanUtils;

import com.groupc.flippedclass.dto.UserDto;
import com.groupc.flippedclass.entity.User;

public class UserConverter {

	public static User userDtoToEntity(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return user;
	}
}
