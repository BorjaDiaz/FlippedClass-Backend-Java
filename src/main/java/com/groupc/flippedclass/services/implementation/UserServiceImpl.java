package com.groupc.flippedclass.services.implementation;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.dto.UserDto;
import com.groupc.flippedclass.entity.Role;
import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.helper.RoleHelper;
import com.groupc.flippedclass.message.request.SignUpForm;
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
	RoleHelper roleHelper;
	
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
	public boolean updateUser(SignUpForm signupForm) {
		try {
			User user = userRepository.findByUsername(signupForm.getUsername()).get();
			user.setName(signupForm.getName());
			user.setSurname(signupForm.getSurname());
			user.setEmail(signupForm.getEmail());
			Set<String> strRoles = signupForm.getRole();
			Set<Role> roles = roleHelper.getValidRoles(strRoles);
			user.setRoles(roles);
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

	@Override
	public boolean updatePassword(SignUpForm signupForm) {
		try {
			User user = userRepository.findByUsername(signupForm.getUsername()).get();
			user.setPassword(encoder.encode(signupForm.getPassword()));
			user.setFirstLogin(1);
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
