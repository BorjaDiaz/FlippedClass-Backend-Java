package com.groupc.flippedclass.services.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.converter.UserConverter;
import com.groupc.flippedclass.dto.UserDto;
import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.repository.RoleRepository;
import com.groupc.flippedclass.repository.UserRepository;
import com.groupc.flippedclass.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public String passwordEncoder(String password) {
		return encoder.encode(password);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean updateUser(UserDto userDto) {
		try {
			//TODO AÑADIR MODIFICACION DE ROLES.
			User user = userRepository.findByUsername(userDto.getUsername()).get();
			user.setName(userDto.getName());
			user.setSurname(userDto.getSurname());
			user.setEmail(userDto.getEmail());
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean switchUserEnabled(UserDto userDto) {
		User user = userRepository.findByUsername(userDto.getUsername()).get();
		if(!userDto.isEnabled()) {
			user.setEnabled(true);
			userRepository.save(user);
			return true;
		} else {
			user.setEnabled(false);
			userRepository.save(user);
			return false;
		}
	}

}
