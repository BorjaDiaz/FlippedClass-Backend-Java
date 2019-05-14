package com.groupc.flippedclass.services;

import java.util.List;

import com.groupc.flippedclass.dto.UserDto;
import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.message.request.SignUpForm;

public interface UserService {

	public String passwordEncoder(String password);
	public List<User> getAllUsers();
	public boolean updateUser(SignUpForm signupForm);
	public boolean updatePassword(SignUpForm signupForm);
	public boolean switchUserEnabled(UserDto userDto);
}
