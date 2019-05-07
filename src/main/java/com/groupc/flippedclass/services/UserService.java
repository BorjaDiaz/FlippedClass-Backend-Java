package com.groupc.flippedclass.services;

import java.util.List;

import com.groupc.flippedclass.entity.User;

public interface UserService {

	public String passwordEncoder(String password);
	public List<User> getAllUsers ();
}
