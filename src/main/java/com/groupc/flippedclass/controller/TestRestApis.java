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

import com.groupc.flippedclass.dto.UserDto;
import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.message.request.SignUpForm;
import com.groupc.flippedclass.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestApis {
	
	static Logger log = Logger.getLogger(TestRestApis.class.getName());
	
	@Autowired
	UserService userService;

	
	@GetMapping("/api/test/table")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> adminTable() {
		log.info("En adminTable");
		log.debug(userService.getAllUsers());
		return userService.getAllUsers();
	}
	
	@PostMapping("/api/test/updateUser")
	@PreAuthorize("hasRole('ADMIN')")
    public void modifyUser(@RequestBody SignUpForm signupForm) {
		log.info("En modifyUser");
    	userService.updateUser(signupForm);
    }
	
	@PostMapping("/api/user/updatePassword")
	@PreAuthorize("hasRole('USER') or hasRole('TEACHER') or hasRole('ADMIN')")
    public void updatePassword(@RequestBody SignUpForm signupForm) {
		log.info("En updatePassword");
    	userService.updatePassword(signupForm);
    }
	
	@PostMapping("/api/user/switchEnabled")
	@PreAuthorize("hasRole('ADMIN')")
    public void switchEnabled(@RequestBody UserDto userDto) {
		log.info("En switchEnabled");
    	userService.switchUserEnabled(userDto);
    }
	
}
