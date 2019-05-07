package com.groupc.flippedclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestApis {
	
	@Autowired
	UserService userService;

	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content";
	}
	
	@GetMapping("/api/test/teacher")
	@PreAuthorize("hasRole('TEACHER') or hasRole('ADMIN')")
	public String teacherAccess() {
		return "Teacher Content";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Content";
	}
	
	@GetMapping("/api/test/table")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> adminTable() {
		return userService.getAllUsers();
	}
}
